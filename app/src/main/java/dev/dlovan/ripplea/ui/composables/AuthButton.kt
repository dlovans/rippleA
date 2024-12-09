package dev.dlovan.ripplea.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.dlovan.ripplea.R
import dev.dlovan.ripplea.ui.theme.Emerald
import dev.dlovan.ripplea.utils.AuthType

@Composable
fun AuthButton(
    authType: AuthType,
    authProviderText: String,
    authProviderIcon: Int,
    onClick: () -> Unit
) {
    val authButtonText = when (authType) {
        AuthType.SIGN_IN -> "Continue with $authProviderText"
        AuthType.SIGN_UP -> "Sign up with $authProviderText"
    }

    Surface(
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, Emerald),
        color = Color.Transparent,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(
                    color = Emerald,
                    bounded = true,
                    radius = 20.dp
                )
            ) { onClick() }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = authProviderIcon),
                contentDescription = authProviderText,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 10.dp, end = 20.dp)
                    .size(25.dp)
            )
            Text(
                text = authButtonText,
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun AuthButtonPreview() {
    AuthButton(
        authType = AuthType.SIGN_IN,
        authProviderText = "Google",
        authProviderIcon = R.drawable.baseline_camera_alt_24,
    ) {
        println("Google btn clicked")
    }
}