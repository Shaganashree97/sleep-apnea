/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package com.example.secondapp.presentation

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.example.secondapp.R
import com.example.secondapp.presentation.theme.SecondAppTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ButtonDefaults
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestPermissions(arrayOf(ComponentActivity.SENSOR_SERVICE), ComponentActivity.BIND_IMPORTANT)
        setContent {
            ShowPage()
        }

    }
}



/*
* * * Page navigating function
*/
@Composable
fun ShowPage(){
    var page by rememberSaveable { mutableStateOf(2) }

    when(page){
        2 -> GetStarted(click = {page = 3})
        3 -> StartPage(click = { page = 5})
//        4 -> SensorPermissionScreen{}
        5 -> InfoPage(click = { page = 6})
        6 -> HomePage(click = {page = 7})
        7 -> DangerScreen(click = {page =8})
        8 -> InsightsPage (click = {page =9})
        9 -> InsightsPage2 (click = {page=10})
        10 -> AlertScreen(click = {page=2})
    }

}

/*
* * *  Get started page, page no.2
*/
@Composable
fun GetStarted(click:() -> Unit) {
    SecondAppTheme {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)) {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(top = 45.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Take control of your sleep....", modifier = Modifier
                        .padding(start = 35.dp)
                        .padding(bottom = 50.dp),
                    fontSize = 13.sp
                )
            }

            Row(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(top = 13.dp),
            ) {
                Button(onClick = { click() }, colors= ButtonDefaults.buttonColors(backgroundColor = Color.White),modifier = Modifier
                    .height(20.dp)
                    .padding(start = 80.dp)) {
                    Text(text = "Get started", fontSize = 8.sp, color = Color.Black,modifier=Modifier.padding(horizontal = 8.dp))
                }


            }
        }

    }

}


/*
* * *  start page, page no.3
*/
@Composable
fun StartPage(click: () -> Unit) {
    SecondAppTheme {

        Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)) {
            Row(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Monitor sleep apnea and get notified", modifier = Modifier
                        .padding(start = 45.dp, bottom = 50.dp)
                        .width(90.dp),
                    lineHeight = 16.sp,
                    fontSize = 13.sp
                )
            }


            Row(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .padding(top = 5.dp),
            ) {
                Button(onClick = {click() }, colors= ButtonDefaults.buttonColors(backgroundColor = Color.White),modifier = Modifier
                    .height(20.dp)
                    .padding(start = 84.dp)) {
                    Text(text = "Start", fontSize = 8.sp, color = Color.Black,modifier = Modifier.padding(start=5.dp,end=5.dp))
                }


            }

        }

    }

}


/*
* * *  Info  page, page no.5
*/
@Composable
fun InfoPage(click: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row() {
            Text(
                text = "What is normal Apnea?",
                color = Color.White, fontSize = 12.sp)
        }
        Row(){
            Text(
                text = "0 - 5          →     Normal\n5 - 15       →      Mild \n15 - 31     →     Moderate\nAbove 31 →     Severe",
                color = Color.White,
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp),
                lineHeight = 16.sp
            )
        }

        Row( modifier = Modifier.padding(top=15.dp)){
        Button(onClick = { click()  }, colors= ButtonDefaults.buttonColors(backgroundColor = Color.White),modifier = Modifier
            .height(20.dp)
            .padding(start = 55.dp)) {
            Text(text = "Get started", fontSize = 8.sp, color = Color.Black, modifier = Modifier.padding(start=7.dp,end=7.dp))
        }

        }

    }

}

/*
* * *  Home page, page no.6
*/


/*
* * *  Home page, page no.6
*/
@Composable
fun HomePage(click: () -> Unit){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.padding(bottom = 5.dp)
        ) {
            Text(
                text = "Hello User",
                color = Color.White, fontSize = 12.sp)
        }
        Row(
            modifier = Modifier
                .width(90.dp)
                .height(90.dp),
        ){
            Image(
              painter = painterResource(id = R.drawable.img),
                contentDescription =  stringResource(id = R.string.tick)
            )
        }

        Row( modifier = Modifier.padding(top=12.dp)){
            Button(onClick = {  click() }, colors= ButtonDefaults.buttonColors(backgroundColor = Color.White),modifier = Modifier
                .height(20.dp)
                .padding(start = 50.dp,)) {
                Text(text = "More Details", fontSize = 8.sp, color = Color.Black, modifier = Modifier.padding(start=7.dp, end = 7.dp))
            }

        }

    }
}

/*
* * *  Danger scren page, page no.7
*/
@Composable
fun DangerScreen(click: () -> Unit){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.padding(bottom = 10.dp)
        ) {
            Text(
                text = "Hello User",
                color = Color.White, fontSize = 12.sp)
        }
        Row(
            modifier = Modifier
                .width(40.dp)
                .height(60.dp)
                .padding(top = 10.dp, bottom = 10.dp),
        ){
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription =  stringResource(id = R.string.tick),

            )
        }
        Row( ){
                Text(text = "Don't fret Sleep Apnea diagnosed", fontSize = 8.sp, color = Color.White, modifier = Modifier.padding(start=7.dp, end = 7.dp))
        }
        Row( modifier = Modifier.padding(top=15.dp)){
            Button(onClick = {  click() }, colors= ButtonDefaults.buttonColors(backgroundColor = Color.White),modifier = Modifier
                .height(20.dp)
                .padding(start = 65.dp,)) {
                Text(text = "Get Report", fontSize = 8.sp, color = Color.Black, modifier = Modifier.padding(start=7.dp, end = 7.dp))
            }

        }

    }
}


/*
* * *  Insights page, page no.8
*/
@Composable
fun InsightsPage(click: () -> Unit){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 20.dp),

    ) {

        Row(
            modifier = Modifier.padding(bottom = 5.dp, start = 10.dp)
        ) {
            Text(
                text = "Hello User",
                color = Color.White, fontSize = 17.sp)
        }
        Row(
            modifier = Modifier.padding(start=10.dp)

        ){
            Text(text = "Severity", fontSize = 12.sp)
        }

        Row(
            modifier = Modifier.padding(start=10.dp)
        ){
            Column() {
                Text(text = "30",color=Color("#D31027".toColorInt()), fontSize = 50.sp)
            }
            Column(
            ) {
             Text(text="AHI",modifier = Modifier.padding(top=35.dp,start=10.dp))
            }
        }

        Row( modifier = Modifier.padding(top=15.dp)){
            Button(onClick = {  click() }, colors= ButtonDefaults.buttonColors(backgroundColor = Color.White),modifier = Modifier
                .height(20.dp)
                .padding(start = 65.dp,)) {
                Text(text = "Get Report", fontSize = 8.sp, color = Color.Black, modifier = Modifier.padding(start=7.dp, end = 7.dp))
            }

        }

    }
}


@Composable
fun InsightsPage2(click: () -> Unit){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 20.dp),

        ) {

        Row(
            modifier = Modifier.padding(bottom = 5.dp,start=10.dp)
        ) {
            Text(
                text = "Hello User",
                color = Color.White, fontSize = 17.sp)
        }
        Row(
            modifier = Modifier.padding(start=10.dp)

        ){
            Text(text = "Average SpO2", fontSize = 12.sp)
        }

        Row(
            modifier = Modifier.padding(start=10.dp)
        ){
            Column() {
                Text(text = "98",color=Color("#1488CC".toColorInt()), fontSize = 50.sp)
            }
            Column(
            ) {
                Text(text="%",modifier = Modifier.padding(top=35.dp,start=10.dp))
            }
        }

        Row( modifier = Modifier.padding(top=15.dp)){
            Button(onClick = {  click() }, colors= ButtonDefaults.buttonColors(backgroundColor = Color.White),modifier = Modifier
                .height(20.dp)
                .padding(start = 65.dp,)) {
                Text(text = "Get Report", fontSize = 8.sp, color = Color.Black, modifier = Modifier.padding(start=7.dp, end = 7.dp))
            }

        }

    }
}


@Composable
fun AlertScreen(click: () -> Unit){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, top = 20.dp),

        ) {

        Row(
            modifier = Modifier.padding(bottom = 5.dp,start=20.dp).width(85.dp)
        ) {
            Text(
                text = "Sleep Apnea Diagnosed",
                color = Color("#E65C00".toColorInt()),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold

            )
        }
        Row(
            modifier = Modifier.padding(top=10.dp,start=20.dp)

        ){
            Text(text = "Change sleep position", fontSize = 12.sp)
        }


        Row( modifier = Modifier.padding(top=20.dp)){
            Button(onClick = {  click() }, colors= ButtonDefaults.buttonColors(backgroundColor = Color.White),modifier = Modifier
                .height(20.dp)
                .padding(start = 80.dp)) {
                Text(text = "Dismiss", fontSize = 8.sp, color = Color.Black, modifier = Modifier.padding(start=7.dp, end = 7.dp))
            }

        }

    }
}

/*
* * * Permission section, page no. 5
*/

@Composable
fun SensorPermissionScreen(
    onPermissionGranted: () -> Unit,
) {
    val context = LocalContext.current
    val permissionState = remember { mutableStateOf(false) }
    val snackbarVisibleState = remember { mutableStateOf(false) }

    Column {

        Text(
            text = "This app requires sensor permission.",
            style = MaterialTheme.typography.caption2,
            modifier = Modifier.padding(24.dp)
        )
        Button(
            onClick = {
                if (hasSensorPermission(context)) {
                    permissionState.value = true
                    onPermissionGranted()
                } else {
                    requestSensorPermission(context)
                }
            },
            enabled = !permissionState.value
        ) {
            Text(text = "Grant Permission")
        }
    }

//    if (snackbarVisibleState.value) {
//        SwipeableSurface(
//            state = rememberSwipeableState(initialValue = SwipeableState.Closed),
//            anchors = mapOf(0f to SwipeableState.Closed),
//            backgroundOpacity = 0f,
////            contentColor = .colors.snackbarContentColor
//        ) {
//            androidx.wear.compose.material.SwipeToDismissBoxDefaults(
//                onDismiss = { snackbarVisibleState.value = false },
//                modifier = Modifier.padding(bottom = 16.dp),
//                text = { Text("Permission granted!") }
//            )
//        }
//    }
}



private fun hasSensorPermission(context: Context): Boolean {
    val permission = Manifest.permission.BODY_SENSORS
    val result = ContextCompat.checkSelfPermission(context, permission)
    return result == PackageManager.PERMISSION_GRANTED
}

private fun requestSensorPermission(context: Context) {
    val permission = Manifest.permission.BODY_SENSORS
    ActivityCompat.requestPermissions(context as Activity, arrayOf(permission), 0)
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
//    GetStarted() {}
//    startPage()
//    SensorPermissionScreen {}
//    InfoPage(){}
//    DangerScreen(){}
//    ShowPage()
//    InsightsPage2(){}
//    HomePage(){}
    AlertScreen(){}
}
