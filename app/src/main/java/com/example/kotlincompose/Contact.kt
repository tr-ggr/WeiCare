package com.example.kotlincompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlincompose.ui.theme.BackgroundColor
import com.example.kotlincompose.ui.theme.ChineseSilver
import com.example.kotlincompose.ui.theme.CleanWhite
import com.example.kotlincompose.ui.theme.GoodGreen

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun Contact() {
    Column(
        modifier = Modifier
            .background(color = BackgroundColor)
            .fillMaxSize()
            .padding(25.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ){
        Column{
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ){
                Text(text ="Devices", color = CleanWhite, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier,
                    colors = ButtonDefaults.buttonColors(containerColor = ChineseSilver ),

                ) {
                    Text("Pair Device", fontSize = 10.sp, color = BackgroundColor)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.width(100.dp),
                thickness = 2.dp,
                color = CleanWhite
            )
            Spacer(modifier = Modifier.height(30.dp))
        }

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalArrangement = Arrangement.spacedBy(20.dp),
            maxItemsInEachRow = 2
        ){
            DeviceCard(isActive = true, watchName = "Huawei Watch GT 2 Sport", batteryInfo = "80")
            DeviceCard(isActive = false, watchName = "Samsung Galaxy Watch 4", batteryInfo = "90")
            DeviceCard(isActive = false, watchName = "Apple Watch Series 6", batteryInfo = "72")
            DeviceCard(isActive = false, watchName = "Fitbit Versa 3", batteryInfo = "65")

        }

        Column{
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,

                ){

                Text(text ="Contacts", color = CleanWhite, fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(containerColor = GoodGreen )


                ) {
                    Text("Sync Contacts", fontSize = 10.sp, color = BackgroundColor)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            HorizontalDivider(
                modifier = Modifier.width(100.dp),
                thickness = 2.dp,
                color = CleanWhite
            )

        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            ContactCard(name = "John Smith", "+1234567890")
            ContactCard(name = "Alice Johnson", "+1987654321")
            ContactCard(name = "Michael Brown", "+1122334455")
            ContactCard(name = "Emily Wilson", "+1555666777")
            ContactCard(name = "David Lee", "+1654321890")
            ContactCard(name = "Sarah Garcia", "+1789456123")
            ContactCard(name = "Ryan Martinez", "+1876543210")
            ContactCard(name = "Jennifer Lopez", "+1998877665")
            ContactCard(name = "Christopher Taylor", "+1888776655")
            ContactCard(name = "Jessica Clark", "+1666999888")
        }

        Spacer(modifier = Modifier.height(30.dp))




    }
}