package com.example.compose.rally

import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest() {
        val allScreens = RallyScreen.values().toList()

        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {  },
                currentScreen = RallyScreen.Accounts
            )
        }

/** test that the 'accounts' tab is selected */
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()

        //composeTestRule.onRoot().printToLog("currentLabelExists")

/** test that the 'accounts' tab has the proper text */
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertExists()

/** test that uses a matcher to find a node with text 'accounts' whose parent node's content description is 'accounts' */
        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.uppercase()) and
                hasParent(
                    hasContentDescription(RallyScreen.Accounts.name)
                ),
                useUnmergedTree = true
            )
            .assertExists()

    }

}