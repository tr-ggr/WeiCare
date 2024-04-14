package com.example.kotlincompose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Watch
import androidx.compose.material.icons.outlined.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
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

@Preview(showBackground = true)
@Composable
fun Preview(){
    ContactCard(name = "Jane Doe", "+639381983128")
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
            Icon(imageVector = icon, contentDescription = null)
            Text(string, modifier = Modifier.padding(start = 10.dp))
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
