package com.memtionsandroid.memotions.ui.components.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memtionsandroid.memotions.R
import com.memtionsandroid.memotions.data.remote.response.journals.TagsItem
import com.memtionsandroid.memotions.ui.components.main.SearchBar
import com.memtionsandroid.memotions.ui.theme.customColors

@Composable
fun HomeTopBar(
    streak: Int = 1,
    currentEXP: Int = 0,
    nextLevelEXP: Int = 0,
    level: Int = 1,
    filterCount: Int = 0,
    username: String = "Guest",
    searchText: String,
    tags: List<TagsItem>,
    activeTags: List<TagsItem>,
    dateRangeSelected: Pair<Long?, Long?>,
    onTagAdded: (TagsItem) -> Unit,
    onTagRemoved: (TagsItem) -> Unit,
    onSearchValueChange: (String) -> Unit,
    onDateRangeSelected: (Long?, Long?) -> Unit,
) {
    val customColors = MaterialTheme.customColors
    val streakImage = painterResource(id = R.drawable.streak)
    val expImage = painterResource(id = R.drawable.exp)
    val profileImage = painterResource(id = R.drawable.profile)
    var isFilter by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = 4.dp,
        tonalElevation = 8.dp,
        border = BorderStroke(0.5.dp, customColors.outlineColor),
        shape = RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp),

        ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(customColors.backgroundColor)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .statusBarsPadding()
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.weight(1f)
                    ) {
                        Image(
                            painter = profileImage,
                            contentDescription = "Profile Image",
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 8.dp)
                                .weight(1f),
                            text = username,
                            maxLines = 1,
                            overflow = TextOverflow.Clip,
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }

                    Row(
                        modifier = Modifier.padding(start = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(end = 4.dp),
                            color = customColors.TextOnBackgroundColor,
                            style = MaterialTheme.typography.titleSmall,
                            text = "${currentEXP}/${nextLevelEXP}"
                        )
                        Box {
                            Image(
                                painter = expImage,
                                contentDescription = "Streak Icon",
                                modifier = Modifier
                                    .size(24.dp)
                            )

                            Text(
                                modifier = Modifier.align(Alignment.Center),
                                color = customColors.TextOnBackgroundColor,
                                style = MaterialTheme.typography.titleSmall.copy(
                                    fontSize = 10.sp,
                                    textAlign = TextAlign.Center
                                ),
                                text = "${level}"
                            )
                        }
                    }



                    Row(
                        modifier = Modifier.padding(start = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            color = customColors.TextOnBackgroundColor,
                            style = MaterialTheme.typography.titleSmall,
                            text = streak.toString()
                        )
                        Image(
                            painter = streakImage,
                            contentDescription = "Streak Icon",
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .size(24.dp)
                        )
                    }
                }
                SearchBar(
                    filterCount = filterCount,
                    modifier = Modifier.padding(top = 24.dp),
                    isFilter = isFilter,
                    searchText = searchText,
                    onValueChange = onSearchValueChange,
                    onFilterClicked = { isFilter = !isFilter }
                )
                AnimatedVisibility(isFilter) {
                    SearchFilter(
                        tags = tags,
                        activeTags = activeTags,
                        dateRangeSelected = dateRangeSelected,
                        onTagAdded = { onTagAdded(it) },
                        onDateRangeSelected = {startDate, endDate ->
                            onDateRangeSelected(startDate, endDate)
                        },
                        onTagRemoved = { onTagRemoved(it) },
                    )
                }
            }
        }
    }
}
