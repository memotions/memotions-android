package com.memtionsandroid.memotions.ui.components.home

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.memtionsandroid.memotions.data.remote.response.journals.TagsItem
import com.memtionsandroid.memotions.ui.theme.customColors




@Composable
fun TagChip(
    modifier: Modifier = Modifier,
    viewOnly: Boolean = false,
    tag: TagsItem,
    onRemove: () -> Unit
) {
    val customColors = MaterialTheme.customColors

    Box(
        modifier = modifier
            .border(
                width = 0.5.dp,
                color = customColors.onSecondBackgroundColor,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable { onRemove() }
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = tag.name,
                style = MaterialTheme.typography.labelSmall.copy(
                    fontSize = 10.sp
                ),
                color = customColors.onSecondBackgroundColor
            )
            if(!viewOnly){
                Icon(
                    imageVector = Icons.Default.Clear,
                    tint = customColors.onSecondBackgroundColor,
                    contentDescription = null,
                    modifier = Modifier
                        .size(12.dp)
                )
            }
        }

    }
}