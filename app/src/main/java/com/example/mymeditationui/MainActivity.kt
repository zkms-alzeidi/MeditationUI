package com.example.mymeditationui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mymeditationui.ui.theme.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()){
        Column{
            GreetingSection(name = "Zakariya")
            ChipSection(chipsList = listOf("Sweet sleep", "Insomnia", "Depression", "Remix", "Another"))
            MusicRunningSection()
            FeatureSection(
                feature = listOf(
                Feature(
                    title = "Sleep meditation",
                    R.drawable.ic_headphone,
                    BlueViolet1,
                    BlueViolet2,
                    BlueViolet3
                ),
                Feature(
                    title = "Tips for sleeping",
                    R.drawable.ic_videocam,
                    LightGreen1,
                    LightGreen2,
                    LightGreen3
                ),
                Feature(
                    title = "Night island",
                    R.drawable.ic_moon,
                    OrangeYellow1,
                    OrangeYellow2,
                    OrangeYellow3
                ),
                Feature(
                    title = "Calming sounds",
                    R.drawable.ic_music,
                    Beige1,
                    Beige2,
                    Beige3
                )
            )
            )
        }

    }

}


@Composable
fun GreetingSection(
    name:String
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 15.dp, end = 15.dp, bottom = 15.dp),
    ) {

        Column {
            Text(text = "Good Morning, $name", style = MaterialTheme.typography.h5,color = Color.White)
            Text(text ="we wish you have a good day!", style = MaterialTheme.typography.body2, color = Color.White)
        }

        Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search", tint = Color.White,modifier = Modifier.size(24.dp))
    }

}

@Composable
fun ChipSection(chipsList:List<String>){

    var buttonClickedState by remember {
        mutableStateOf(0)
    }

    LazyRow() {
        items(chipsList.size) {
            Box(modifier = Modifier
                .padding(
                    start = 15.dp,
                    top = 15.dp,
                    bottom = 15.dp
                )

                .clip(RoundedCornerShape(10.dp))
                .clickable {
                    buttonClickedState = it
                }
                .background(
                    if (buttonClickedState == it) {
                        ButtonBlue
                    } else {
                        DarkerButtonBlue
                    }
                )
                .padding(15.dp)

            ) {
                Text(
                    text = chipsList[it],
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun MusicRunningSection(){
    Box(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .background(
            LightRed
        )
        .padding(vertical = 30.dp)){

      Row(modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 15.dp),verticalAlignment = Alignment.CenterVertically,horizontalArrangement = Arrangement.SpaceBetween) {
          Column {
              Text(text = "Daily Thought", style = MaterialTheme.typography.h5,color = Color.White)
              Text(text ="meditation . 3-10 min", style = MaterialTheme.typography.body2, color = Color.White)
          }

         Box(contentAlignment = Alignment.Center){
             Canvas(modifier =Modifier.size(50.dp)) {
                 val canvasWidth= size.width
                 val canvasHeight= size.height
                 drawCircle(
                     color = ButtonBlue,
                     center= Offset(x= canvasWidth/2, y = canvasHeight/2),
                     radius = size.minDimension/2
                 )
             }
             Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "play",tint = Color.White,modifier = Modifier.size(15.dp))
         }
      }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(feature:List<Feature>){

    Box(modifier = Modifier.fillMaxSize()){
        Column() {
            Text(text = "Featured", style = MaterialTheme.typography.h4, color = Color.White,modifier = Modifier.padding(vertical = 10.dp,horizontal = 15.dp))

            LazyVerticalGrid(
                cells = GridCells.Fixed(2),
                contentPadding = PaddingValues(start = 7.5.dp,end = 7.5.dp, bottom = 15.dp),
                modifier = Modifier.fillMaxHeight()) {
                items(feature.size){
                    FeatureItem(feature[it])
                }
            }
        }
    }

}

@Composable
fun FeatureItem(feature: Feature){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(feature.darkColor)
    ) {
        val width= constraints.maxWidth
        val height=constraints.maxHeight

        //Medium color path
        val mediumColoredPoint1 = Offset(0f, height * 0.3f)
        val mediumColoredPoint2 = Offset(width * 0.1f, height * 0.35f)
        val mediumColoredPoint3 = Offset(width * 0.4f, height * 0.05f)
        val mediumColoredPoint4 = Offset(width * 0.75f, height * 0.7f)
        val mediumColoredPoint5 = Offset(width * 1.4f, -height.toFloat())

        val mediumColoredPath= Path().apply {
            moveTo(mediumColoredPoint1.x,mediumColoredPoint1.y)
            standard(mediumColoredPoint1,mediumColoredPoint2)
            standard(mediumColoredPoint2,mediumColoredPoint3)
            standard(mediumColoredPoint3,mediumColoredPoint4)
            standard(mediumColoredPoint4,mediumColoredPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standard(lightPoint1, lightPoint2)
            standard(lightPoint2, lightPoint3)
            standard(lightPoint3, lightPoint4)
            standard(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {

            drawPath(
                path = mediumColoredPath,
                color = feature.mediumColor
            )

            drawPath(
                path = lightColoredPath,
                color = feature.lightColor
            )
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)){

            Text(
                text = feature.title,
                style = MaterialTheme.typography.h6,
                lineHeight = 26.sp,
                color= TextWhite,
                modifier = Modifier.align(
                    Alignment.TopStart
                )
            )

            Icon(painter = painterResource(id = feature.iconId), contentDescription = "icon", modifier = Modifier
                .size(20.dp)
                .align(
                    Alignment.BottomStart
                ),tint = Color.White)

            Box(modifier = Modifier
                .align(Alignment.BottomEnd)
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .background(ButtonBlue)){
                Text(text = "start", fontWeight = FontWeight.Bold, color = TextWhite,modifier = Modifier.padding(10.dp))
            }

        }




    }
}
