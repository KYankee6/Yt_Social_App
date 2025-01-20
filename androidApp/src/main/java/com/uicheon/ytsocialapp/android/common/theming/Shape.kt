package com.uicheon.ytsocialapp.android.common.theming

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import com.uicheon.ytsocialapp.android.common.theming.LargeSpacing
import com.uicheon.ytsocialapp.android.common.theming.MediumSpacing
import com.uicheon.ytsocialapp.android.common.theming.SmallSpacing

val Shapes = Shapes(
    small = RoundedCornerShape(SmallSpacing),
    medium = RoundedCornerShape(MediumSpacing),
    large = RoundedCornerShape(LargeSpacing)
)