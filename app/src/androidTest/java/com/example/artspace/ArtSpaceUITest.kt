package com.example.artspace

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule


class ArtSpaceUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun checkPaintingStatus(){
        composeTestRule.setContent {
            ArtSpaceTheme {
                DisplayPainting()
            }
        }

        composeTestRule.onAllNodesWithContentDescription("The Scream")
    }
}