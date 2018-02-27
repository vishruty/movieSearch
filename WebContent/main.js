function myFunction(){
var APIKEY = "1f39dea1e4239caa8c1ae2c4975e9926";
var baseURL="https://api.themoviedb.org/3/";
let url="".concat(baseURL,'configuration?api_key=',APIKEY);
fetch(url)
.then((result)=>{
	return result.json();
})
.then((data)=>{
	console.log('config:',data);
	 var x = document.getElementById("movie_name").value; 
	runSearch(x);
})
} 

let runSearch=function(keyword){
	let url=''.concat('https://api.themoviedb.org/3/','search/movie?api_key=','1f39dea1e4239caa8c1ae2c4975e9926','&query=',keyword);
	fetch(url)
	.then(result=>result.json())
	.then((data)=>{
		//document.getElementById('output').innerHTML=JSON.stringify(data,null,2);
		//console.log(data.results.length);
		document.getElementById('output').innerHTML=innerCode(data);
		
	})
}

let innerCode=function createData(data){
	var len=data.results.length;
	var movieObj="";
	 for(var i=0;i<len;i++){
	        movieObj+="<p class='nested_para'>";
	        movieObj+="Title:" + data.results[i].title + "<br>";
	        movieObj+= "Release date: " + data.results[i].release_date + "<br>";
	        movieObj+= "Rating: " + data.results[i].vote_average + "<br>";
	        if(data.results[i].overview.length!=0){
	            movieObj+= "Overview: " + data.results[i].overview + "<br>";
	        }
	    //    movieObj+= "<form>";
	        movieObj+="<input type='checkbox' name='movies_to_watch' value='" + data.results[i].title + "'><br>";
	    //    movieObj+= "</form>"
	        movieObj+="</p>";
	        movieObj+= "<hr>";
	    }
	    movieObj+="<input type='submit' value='click here to add these movies'>";
	    return movieObj;
	}


