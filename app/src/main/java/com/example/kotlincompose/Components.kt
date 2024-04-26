package com.example.kotlincompose

import android.graphics.drawable.shapes.Shape
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.SentimentNeutral
import androidx.compose.material.icons.filled.SentimentVerySatisfied
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material.icons.outlined.SentimentVeryDissatisfied
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.ChineseSilver
import com.example.kotlincompose.ui.theme.CleanWhite
import com.example.kotlincompose.ui.theme.DangerRed
import com.example.kotlincompose.ui.theme.ForegroundColor
import com.example.kotlincompose.ui.theme.GoodGreen
import com.example.kotlincompose.ui.theme.RiskyOrange
import com.example.kotlincompose.ui.theme.TertiaryColor
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollSpec
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollState
import com.patrykandpatrick.vico.compose.component.marker.markerComponent
import com.patrykandpatrick.vico.compose.component.shape.shader.fromBrush
import com.patrykandpatrick.vico.compose.style.ProvideChartStyle
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.chart.DefaultPointConnector
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes.rectShape
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShader
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.ChartModelProducer
import com.patrykandpatrick.vico.core.entry.FloatEntry

import rememberMarker

@Preview(showBackground = true)
@Composable
fun Preview(){
//    HomeCard(icon = Icons.Filled.Bloodtype,name = "Blood Pressure", value = "124/88 mmHg")
//    WeeklyGraph()
}




@Composable
fun WeeklyGraph(refreshState : MutableState<Int>){
//    val refreshedDataset = remember { mutableIntStateOf(refreshValue) }
    val modelProducer = remember { ChartEntryModelProducer() }
    val datasetForModel = remember { mutableStateListOf(listOf<FloatEntry>()) }
    val datasetColumnSpec = remember { arrayListOf<LineComponent>()}

    LaunchedEffect(key1 = refreshState.value){
        datasetForModel.clear()
        datasetColumnSpec.clear()
        var xPos = 0f
        val dataPoints = arrayListOf<FloatEntry>()

        datasetColumnSpec.add(
            LineComponent(
                color = GoodGreen.toArgb(),
                dynamicShader = DynamicShaders.fromBrush(
                    brush = Brush.verticalGradient(
                        colors = listOf(GoodGreen.copy(alpha = 0.5f), GoodGreen.copy(alpha = 0.1f))
                    )
                ),
                thicknessDp = 10f,

            )
        )

        for(i in 1..7){
            val randomYFloat = (0..10).random().toFloat()
            dataPoints.add(FloatEntry(x = xPos, y = randomYFloat))
            xPos += 1f
        }

        datasetForModel.add(dataPoints)

        modelProducer.setEntries(datasetForModel)
    }

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)){
        Card(
            modifier = Modifier
                .fillMaxWidth()

        ){
            if(datasetForModel.isNotEmpty())
                ProvideChartStyle {
                    val marker = rememberMarker()
                    Chart(
                        chart = columnChart(
                            columns = datasetColumnSpec,
                        ),
                        chartModelProducer = modelProducer,

                        startAxis = rememberStartAxis(
                            title = "Top Values",
                            tickLength = 0.dp,
                            valueFormatter = { value, _ -> value.toInt().toString() },
                            itemPlacer = AxisItemPlacer.Vertical.default(
                                maxItemCount = 6
                            )
                        ),

                        bottomAxis = rememberBottomAxis(
                            title = "Days of the Week",
                            tickLength = 0.dp,
                            valueFormatter = { value, _ ->
                                val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                                daysOfWeek[value.toInt() % daysOfWeek.size]
                            },
                            guideline = null,
                        ),

                        marker = marker,

                        chartScrollSpec = rememberChartScrollSpec(isScrollEnabled = false),
                        isZoomEnabled = false,

                        )
                }
        }

        TextButton(modifier = Modifier.fillMaxWidth(),
            onClick = {}){
            Text("Refresh", textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun HomeCard(icon : ImageVector, name : String, value : String){
    Column (
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(color = ForegroundColor)
            .width(160.dp)
            .height(150.dp)
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,

    ){
        Icon(imageVector =  icon,
            tint = CleanWhite,
            contentDescription = null,
            modifier = Modifier.size(50.dp))
        Spacer(modifier = Modifier.height(5.dp))
        Text(name, color = CleanWhite,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Text(value, color = ChineseSilver,
            fontSize = 15.sp)
    }
}

@Composable
fun TroponinCard(value : Float){
    var icon: ImageVector? = null;
    var color: Color? = null;
    var text: String? = null;

    if(value < 10f){
        icon = Icons.Filled.SentimentVerySatisfied
        color = GoodGreen
        text = "Normal"
    } else if(value < 20f){
        icon = Icons.Filled.SentimentNeutral
        color = RiskyOrange
        text = "At Risk"
    } else {
        icon = Icons.Outlined.SentimentVeryDissatisfied
        color = DangerRed
        text = "In Danger"
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = ForegroundColor)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
            Column (
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween

            ){
                Icon(imageVector = Icons.Filled.BubbleChart,
                    tint = CleanWhite,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp))
                Spacer(modifier = Modifier.height(5.dp))
                Text("Troponin - I", color = CleanWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)
                Text("0.01 ng/mL", color = ChineseSilver,
                    fontSize = 15.sp)
            }


            Column (
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(color = TertiaryColor)
                    .width(165.dp)
                    .fillMaxHeight()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Icon(imageVector = icon,
                    tint = color, contentDescription = null,
                    modifier = Modifier.size(50.dp))
                Text(text, color = CleanWhite, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Text("${value} ng/mL", color = ChineseSilver)
            }

    }
}

@Composable
fun ProfileButtons(icon : ImageVector, string : String){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = ForegroundColor)


    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = CleanWhite)
            Text(string, modifier = Modifier.padding(start = 10.dp), color = CleanWhite)
        }

    }
}


@Composable
fun ContactCard(name : String, number : String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = ForegroundColor)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .width(250.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(40.dp)
                    .background(color = Color.Blue)


            ){

            }

            Column(

            ) {
                Text(name, color = CleanWhite, fontWeight = FontWeight.Bold)
                Text( number , color = ChineseSilver)
            }
        }

        Demo_DropDownMenu()
    }
}


@Composable
fun DeviceCard(isActive : Boolean, watchName : String, batteryInfo : String){
    Column(
        modifier = Modifier
            .size(160.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color = ForegroundColor)
            .border(
                color = if (isActive) GoodGreen else ForegroundColor,
                width = 2.dp,
                shape = RoundedCornerShape(15.dp)
            )
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(imageVector = Icons.Default.Watch, tint = CleanWhite, contentDescription = null, modifier = Modifier.size(70.dp))
            Text("${batteryInfo}%", color = CleanWhite, fontWeight = FontWeight.Bold, fontSize = 35.sp)
        }
        Text(text = watchName,  color = CleanWhite,fontWeight = FontWeight.Bold, fontSize = 20.sp)

    }
}

@Composable
fun Demo_DropDownMenu() {
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .wrapContentSize(Alignment.TopEnd)
    ) {
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More",
                tint = CleanWhite
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Contact") },
                onClick = { Toast.makeText(context, "Load", Toast.LENGTH_SHORT).show() }
            )
            DropdownMenuItem(
                text = { Text("Delete") },
                onClick = { Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show() }
            )
        }
    }
}


@Composable
fun GoodNotificationCard(isRead : Boolean){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = if (isRead) BackgroundColor else ForegroundColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = GoodGreen),
            contentAlignment = Alignment.Center

            

        ){
            Icon(imageVector = Icons.Default.FavoriteBorder , contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(

        ){
            Text("8:50 am - Today", color = ChineseSilver, fontSize = 10.sp)
            Text("You're in Good Shape!", color = Color.White, fontWeight = FontWeight.Bold)
            Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.  of Lorem Ipsum.", color = Color.White, fontSize = 10.sp)
        }



    }

}


@Composable
fun RiskyNotificationCard(isRead : Boolean){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = if (isRead) BackgroundColor else ForegroundColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = RiskyOrange),
            contentAlignment = Alignment.Center



        ){
            Icon(imageVector = Icons.Outlined.Warning, contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(

        ){
            Text("8:50 am - Today", color = ChineseSilver, fontSize = 10.sp)
            Text("You’re at Risk!", color = Color.White, fontWeight = FontWeight.Bold)
            Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.  of Lorem Ipsum.", color = Color.White, fontSize = 10.sp)
        }


    }

}



@Composable
fun DangerNotificationCard(isRead : Boolean){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = if (isRead) BackgroundColor else ForegroundColor)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(color = DangerRed),
            contentAlignment = Alignment.Center



        ){
            Icon(imageVector = Icons.Outlined.Warning, contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp))
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(

        ){
            Text("8:50 am - Today", color = ChineseSilver, fontSize = 10.sp)
            Text("You were in danger!", color = Color.White, fontWeight = FontWeight.Bold)
            Text("Lorem Ipsum is simply dummy text of the printing and typesetting industry.  of Lorem Ipsum.", color = Color.White, fontSize = 10.sp)
        }


    }

}
