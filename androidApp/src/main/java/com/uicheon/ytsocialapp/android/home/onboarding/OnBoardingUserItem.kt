package com.uicheon.ytsocialapp.android.home.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uicheon.ytsocialapp.android.R
import com.uicheon.ytsocialapp.android.common.components.CircleImage
import com.uicheon.ytsocialapp.android.common.components.FollowsButton
import com.uicheon.ytsocialapp.android.common.components.fake_data.FollowsUser
import com.uicheon.ytsocialapp.android.common.components.fake_data.sampleUsers
import com.uicheon.ytsocialapp.android.common.theming.MediumSpacing
import com.uicheon.ytsocialapp.android.common.theming.SmallSpacing
import com.uicheon.ytsocialapp.android.common.theming.SocialAppTheme

@Composable
fun OnBoardingUserItem(
    modifier: Modifier = Modifier,
    followsUser: FollowsUser,
    onUserClick: (FollowsUser) -> Unit,
    isFollowing: Boolean = false,
    onFollowsButtonClick: (Boolean, FollowsUser) -> Unit
) {
    Card(
        modifier = modifier
            .height(140.dp)
            .width(130.dp)
            .clickable { onUserClick(followsUser) },
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(MediumSpacing),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            CircleImage(
                modifier = modifier.size(50.dp),
                imageUrl = followsUser.profileUrl
            ) {
                onUserClick(followsUser)
            }

            Spacer(modifier = modifier.height(SmallSpacing))

            Text(
                text = followsUser.name,
                style = MaterialTheme.typography.titleSmall, maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = modifier.height(MediumSpacing))

            FollowsButton(
                modifier = modifier
                    .fillMaxWidth()
                    .heightIn(30.dp),
                text = R.string.follow_text_label,
                onClick = { onFollowsButtonClick(!isFollowing, followsUser) },
            )
        }
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingUserPreview() {
    SocialAppTheme {
        OnBoardingUserItem(
            followsUser = sampleUsers.first(),
            onUserClick = {},
            onFollowsButtonClick = { _, _ -> }
        )
    }
}