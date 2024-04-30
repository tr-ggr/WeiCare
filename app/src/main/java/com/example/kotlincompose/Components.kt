package com.example.kotlincompose

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.drawable.shapes.Shape
import android.text.TextUtils
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
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
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.BatteryFull
import androidx.compose.material.icons.filled.Bloodtype
import androidx.compose.material.icons.filled.BubbleChart
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.Typeface
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.AppTheme
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.ChineseSilver
import com.example.kotlincompose.ui.theme.CleanWhite
import com.example.kotlincompose.ui.theme.DangerRed
import com.example.kotlincompose.ui.theme.ForegroundColor
import com.example.kotlincompose.ui.theme.GoodGreen
import com.example.kotlincompose.ui.theme.RiskyOrange
import com.example.kotlincompose.ui.theme.TertiaryColor
import com.patrykandpatrick.vico.compose.axis.axisLabelComponent
import com.patrykandpatrick.vico.compose.axis.axisLineComponent
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
import com.patrykandpatrick.vico.core.axis.Axis
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.chart.DefaultPointConnector
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes.rectShape
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShader
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.component.text.TextComponent
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.ChartModelProducer
import com.patrykandpatrick.vico.core.entry.FloatEntry

import rememberMarker


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun Preview(){
//    HomeCard(icon = Icons.Filled.Bloodtype,name = "Blood Pressure", value = "124/88 mmHg")
//    WeeklyGraph()
    AppTheme{


        NotificationCard(isRead = false, type = NotificationType.GOOD)

    }
}

@Composable
fun StateTest(){
    var isWeekly by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.Start
    )
    {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Activity", fontSize = 20.sp, color = MaterialTheme.colorScheme.onBackground, fontWeight = FontWeight.Bold)

            Row(
                modifier = Modifier
                    .wrapContentSize(Alignment.Center)
                    .width(100.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text( if (isWeekly) "Weekly" else "Daily", color = MaterialTheme.colorScheme.onBackground)

                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "More",
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("Weekly") },
                        onClick = { isWeekly = true }
                    )
                    DropdownMenuItem(
                        text = { Text("Daily") },
                        onClick = { isWeekly = false }
                    )
                }
            }
        }



        if(!isWeekly){

            DailyGraph()
        } else {
            WeeklyGraph()
        }

    }


}




@Composable
fun WeeklyGraph(){
    val refreshedDataset = remember { mutableIntStateOf(0) }
    val modelProducer = remember { ChartEntryModelProducer() }
    val datasetForModel = remember { mutableStateListOf(listOf<FloatEntry>()) }
    val datasetColumnSpec = remember { arrayListOf<LineComponent>()}

    LaunchedEffect(key1 = refreshedDataset.intValue){
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
        ){
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

                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.secondaryContainer),
                        chartModelProducer = modelProducer,

                        startAxis = rememberStartAxis(
                            title = "Top Values",
                            tickLength = 0.dp,
                            valueFormatter = { value, _ -> value.toInt().toString() },
                            itemPlacer = AxisItemPlacer.Vertical.default(
                                maxItemCount = 6
                            ),
                            label  = axisLabelComponent(
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            ),

                            sizeConstraint = Axis.SizeConstraint.TextWidth("100"),
                        ),

                        bottomAxis = rememberBottomAxis(
                            title = "Days of the Week",
                            tickLength = 0.dp,
                            valueFormatter = { value, _ ->
                                val daysOfWeek = listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                                daysOfWeek[value.toInt() % daysOfWeek.size]
                            },
                            guideline = null,
                            label  = axisLabelComponent(
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        ),

                        marker = marker,

                        chartScrollSpec = rememberChartScrollSpec(isScrollEnabled = false),
                        isZoomEnabled = false,

                        )
                }
        }

    }
}

@Composable
fun DailyGraph(){
    val refreshedDataset = remember { mutableIntStateOf(0) }
    val modelProducer = remember { ChartEntryModelProducer() }
    val datasetForModel = remember { mutableStateListOf(listOf<FloatEntry>()) }
    val datasetLineSpec = remember { arrayListOf<LineChart.LineSpec>()}

    LaunchedEffect(key1 = refreshedDataset.intValue){
        datasetForModel.clear()
        datasetLineSpec.clear()
        var xPos = 0f
        val dataPoints = arrayListOf<FloatEntry>()

        datasetLineSpec.add(
            LineChart.LineSpec(
                lineColor = GoodGreen.toArgb(),
                lineBackgroundShader = DynamicShaders.fromBrush(
                    brush = Brush.verticalGradient(
                        colors = listOf(GoodGreen.copy(alpha = 0.5f), GoodGreen.copy(alpha = 0.1f))
                    )
                ),
                pointConnector = DefaultPointConnector(
                    0f
                )
            )

        )

        for(i in 1..24){
            val randomYFloat = (0..10).random().toFloat()
            dataPoints.add(FloatEntry(x = xPos, y = randomYFloat))
            xPos += 1f
        }

        datasetForModel.add(dataPoints)

        modelProducer.setEntries(datasetForModel)
    }

    Column(modifier = Modifier
        .fillMaxWidth() ){
        Card(
            modifier = Modifier
                .fillMaxWidth()

        ){
            if(datasetForModel.isNotEmpty())
                ProvideChartStyle {
                    val marker = rememberMarker()
                    Chart(
                        modifier = Modifier
                            .background(color = MaterialTheme.colorScheme.secondaryContainer),
                        chart = lineChart(
                            lines = datasetLineSpec,
                        ),
                        chartModelProducer = modelProducer,

                        startAxis = rememberStartAxis(
                            title = "Top Values",
                            tickLength = 0.dp,
                            valueFormatter = { value, _ -> value.toInt().toString() },
                            itemPlacer = AxisItemPlacer.Vertical.default(
                                maxItemCount = 6
                            ),
                            label  = axisLabelComponent(
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            ),

                            sizeConstraint = Axis.SizeConstraint.TextWidth("100"),

                        ),

                        bottomAxis = rememberBottomAxis(
                            title = "Time of Day",
                            tickLength = 0.dp,
                            valueFormatter = { value, _ ->

                                        val hoursOfDay = (0..23).map { it.toString().padStart(2, '0') + ":00" }
                                        hoursOfDay[value.toInt() % hoursOfDay.size]

                            },
                            itemPlacer = AxisItemPlacer.Horizontal.default(
                                spacing = 2,
                                offset = 5
                            ),
                            guideline = null,
                            label  = axisLabelComponent(
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )

                        ),

                        marker = marker,

                        chartScrollSpec = rememberChartScrollSpec(true),

                        )
                }
        }

    }
}

@Composable
fun HomeCard(icon : ImageVector, name : String, value : String){
    Column (
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .width(175.dp)
            .height(70.dp)
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceEvenly,

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, true),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(imageVector =  icon,
                tint = MaterialTheme.colorScheme.onPrimaryContainer,
                contentDescription = null,
                modifier = Modifier.size(30.dp))
            Spacer(modifier = Modifier.height(5.dp))
            Column (
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold)) {
                            append(name)
                        }
                        append("\n") // New line
                        withStyle(style = SpanStyle(fontSize = 13.sp)) {
                            append(value)
                        }
                    },
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    lineHeight = 17.sp
                )
            }

        }

    }
}

@Composable
fun TroponinCard(value : Float){
    var icon: ImageVector? = null;
    var color: Color? = null;
    var text: String? = null;
    var subtext: String? = null;

    if(value < 10f){
        icon = Icons.Filled.SentimentVerySatisfied
        color = GoodGreen

        text = "You're Healthy"
        subtext = "Keep it up!"
    } else if(value < 20f){
        icon = Icons.Filled.SentimentNeutral
        color = RiskyOrange
        text = "You're at Risk!"
        subtext = "Take care!"
    } else {
        icon = Icons.Outlined.SentimentVeryDissatisfied
        color = DangerRed
        text = "You're in Danger!"
        subtext = "Seek help!"
    }

        Column (
            modifier = Modifier
                .width(170.dp)
                .fillMaxHeight()
                .clip(RoundedCornerShape(15.dp))
                .background(color)
                .padding(10.dp),
            verticalArrangement = Arrangement.Bottom,


        ){
            Icon(imageVector = icon,
                tint = if (color == GoodGreen) ForegroundColor else MaterialTheme.colorScheme.onTertiaryContainer,
                contentDescription = null,
                modifier = Modifier.size(50.dp))
            Spacer(modifier = Modifier.height(5.dp))
            Text(text, color = if (color == GoodGreen) ForegroundColor else MaterialTheme.colorScheme.onTertiaryContainer,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                lineHeight = 30.sp
                )
            Spacer(modifier = Modifier.height(5.dp))
            Text(subtext, color = if (color == GoodGreen) ForegroundColor else MaterialTheme.colorScheme.onTertiaryContainer,
                fontSize = 15.sp)
        }
}

@Composable
fun ProfileButtons(icon : ImageVector, string : String){
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)


    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = MaterialTheme.colorScheme.onPrimaryContainer)
            Text(string, modifier = Modifier.padding(start = 10.dp), color = MaterialTheme.colorScheme.onPrimaryContainer)
        }

    }
}


@Composable
fun ContactCard(name : String, number : String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
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
                    .background(color = MaterialTheme.colorScheme.onPrimaryContainer)


            ){

            }

            Column(

            ) {
                Text(name, color = MaterialTheme.colorScheme.onPrimaryContainer, fontWeight = FontWeight.Bold)
                Text( number , color = MaterialTheme.colorScheme.onPrimaryContainer)
            }
        }

        Demo_DropDownMenu()
    }
}

@Composable
fun DeviceCard(name : String, batteryInfo : String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = MaterialTheme.colorScheme.primaryContainer)
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
            Icon(
                imageVector = Icons.Filled.Watch,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Column(

            ) {
                Text(name, color = MaterialTheme.colorScheme.onPrimaryContainer, fontWeight = FontWeight.Bold)

                Text( "$batteryInfo%" , color = MaterialTheme.colorScheme.onPrimaryContainer)


            }
        }

        Demo_DropDownMenu()
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
                tint = MaterialTheme.colorScheme.onPrimaryContainer
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
fun NotificationCard(isRead : Boolean, type : NotificationType){
    val icon = if (type == NotificationType.GOOD) Icons.Default.FavoriteBorder else if (type == NotificationType.RISKY) Icons.Outlined.Warning else Icons.Outlined.Warning
    val color = if (type == NotificationType.GOOD) GoodGreen else if (type == NotificationType.RISKY) RiskyOrange else DangerRed

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .background(color = if (isRead) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.primaryContainer)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(
                modifier = Modifier
                    .size(75.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(color = color),
                contentAlignment = Alignment.Center



            ){
                Icon(imageVector = icon , contentDescription = null, tint = Color.White, modifier = Modifier.size(50.dp))
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(

            ){
                Text("You're in Good Shape!", color = MaterialTheme.colorScheme.onPrimaryContainer, fontWeight = FontWeight.Bold)
                Text("8:50 am - Today", color = MaterialTheme.colorScheme.onPrimaryContainer, fontSize = 15.sp)
            }
        }


        Demo_DropDownMenu()



    }

}


enum class NotificationType {
    GOOD, RISKY, DANGER
}
