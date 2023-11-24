package com.alopgal962.recyclerview

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import org.w3c.dom.Text

fun getSuperheroes():List<Superhero>{
    var listaheroes= mutableListOf<Superhero>()
    listaheroes.add(Superhero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman))
    listaheroes.add(Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan))
    listaheroes.add(Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman))
    listaheroes.add(Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor))
    listaheroes.add(Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern))
    listaheroes.add(Superhero( "Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman))
    return listaheroes
}

@Preview
@Composable
fun SuperheroView() {
    var context = LocalContext.current
    LazyVerticalGrid(columns = GridCells.Fixed(2) ) {
        items(getSuperheroes()) {
            Itemhero(superheroe = it,{Toast.makeText(context,it.realname,Toast.LENGTH_SHORT).show()})
        }
    }
}

@Composable
fun Itemhero(superheroe:Superhero,onItemHero:(Superhero) -> Unit    ){
    val context= LocalContext.current
    val painter= painterResource(id = superheroe.photo)
    Card(modifier = Modifier
        .border(2.dp, Color.Red)
        .clickable { onItemHero(superheroe) }
        .padding(4.dp,4.dp)
    )
    {
        Column(modifier=Modifier.fillMaxWidth()) {
            Image(painter =painter, contentDescription = context.packageName, Modifier.fillMaxWidth(), contentScale = ContentScale.Crop)
            Text(text = superheroe.superheroname, fontSize = 20.sp, modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = superheroe.realname, fontSize = 16.sp,modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(text = superheroe.publisher, fontSize = 14.sp,modifier = Modifier.align(Alignment.End))
        }

    }

}