package com.example.myapp

import android.os.Bundle //bundle is what storees the saved state
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.OnBackPressedCallback
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapp.ui.theme.MyappTheme

class ActivityB : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Custom own  back behavior: close app
        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    finishAffinity() // closes entire app
                }
            }
        )

        setContent {
            MyappTheme {
                ActivityBScreen(
                    onGoToC = {
                        startActivity(
                            android.content.Intent(this, ActivityC::class.java)
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun ActivityBScreen(onGoToC: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Activity B", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onGoToC) {
            Text("Go to C")
        }
    }
}
