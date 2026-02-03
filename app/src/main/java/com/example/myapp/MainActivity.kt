package com.example.myapp

import android.content.Intent //this is for the navigation between the activities
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapp.ui.theme.MyappTheme
import android.util.Log
import androidx.activity.addCallback
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel


class ActivityAViewModel : ViewModel(){
    var randomNumber by mutableStateOf(0)
        private set

    init{
        generateRandom()
    }

    fun generateRandom(){
        randomNumber = (1..100).random()
    }

}
class MainActivity : ComponentActivity() {

    private val viewModel: ActivityAViewModel by viewModels()

    //private var randomNumber by mutableStateOf(0)
    //private var comingFromC = false
    private val TAG ="MainActivityLifeCycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")


            //generateRandom()

        onBackPressedDispatcher.addCallback(this) {
            Log.d(TAG, "Back pressed in Activity A → finish()")
            finish()
        }


        setContent {
            MyappTheme {
                ActivityAScreen(
                    randomNumber = viewModel.randomNumber,
                    onGoToB = {
                        startActivity(Intent(this, ActivityB::class.java))
                        finish() // close app flow
                    },
                    onGoToC = {
                        //comingFromC = true
                        startActivity(Intent(this, ActivityC::class.java))
                    }
                )
            }
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

}



@Composable
fun ActivityAScreen(
    randomNumber: Int,
    onGoToB: () -> Unit,
    onGoToC: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Activity A", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Random Number: $randomNumber")
        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = onGoToB) {
            Text("Go to B")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = onGoToC) {
            Text("Go to C")
        }
    }
}
