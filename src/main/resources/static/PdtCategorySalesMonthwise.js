google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawPdtCategoryMonthwiseSalesTrend);

var sales4 = new Array();
var years4 = new Array();
var months4 = new Array();
var Category4 = new Array();
var eachentry = new Array();

var count4 = 0;

  var i;
  
  var arr = [];
 


function fun(s)
{
		
	
	if(s == 1)
		  str = "Jan";
	  else if(s == 2)
		  str = "Feb";
	  else if(s == 3)
		  str = "March";
	  else if(s == 4)
		  str = "April";
	  else if(s == 5)
		  str = "May";
	  else if(s == 6)
		  str = "June";
	  else if(s == 7)
		  str = "July";
	  else if(s == 8)
		  str = "Aug";
	  else if(s == 9)
		  str = "Sept";
	  else if(s == 10)
		  str = "Oct";
	  else if(s == 11)
		  str = "Nov";
	  else
		  str = "Dec";
	
	return str;
	
}

function drawPdtCategoryMonthwiseSalesTrend() 
{
	
	var data = new google.visualization.DataTable();
	
    data.addColumn('String', 'Months');
    data.addColumn('number', 'beleza_saude');
    data.addColumn('number', 'cool_stuff');
    data.addColumn('number', 'bebes');
    data.addColumn('number', 'relogios_presentes');
    data.addColumn('number', 'brinquedos');
    data.addColumn('number', 'ferramentas_jardim');
    data.addColumn('number', 'moveis_decoracao');
    data.addColumn('number', 'informatica_acessorios');
    data.addColumn('number', 'automotivo');
    data.addColumn('number', 'cama_mesa_banho');
    data.addColumn('number', 'utilidades_domesticas');
    data.addColumn('number', 'esporte_lazer');
    
   
	
	

      
      
      
      
    var tempdata=new Array();
    for(var k=0;k<12;k++)
 	 {tempdata[k]=0}
    tempdata[2]=2;
     for(var i=1;i<eachentry.length;i++){
  	     if(eachentry[i-1].Year+eachentry[i-1].Month==eachentry[i].Year+eachentry[i].Month){
  	    	 for(var j=0;j<8;j++){
  	    		if(data.getColumnLabel(j)==eachentry[i].Category){
  	    			tempdata[j]=eachentry[i].total;
  	    		}
  	    	 }
  	     }
  	     else{
  	    	tempdata[0]=eachentry[i-1].Year+eachentry[i-1].Month;
  	    	data.addRows([tempdata]);
  	    	 var tempdata=new Array();
  	    	 for(var k=0;k<12;k++)
  	    	 {tempdata[k]=0}
  	     }
     }
      
      
  
      
      
      
      
      // data.addRows([
      //   [0, 0, 0],    [1, 10, 5],   [2, 23, 15],  [3, 17, 9],   [4, 18, 10],  [5, 9, 5],
      //   [6, 11, 3],   [7, 27, 19],  [8, 33, 25],  [9, 40, 32],  [10, 32, 24], [11, 35, 27],
      //   [12, 30, 22], [13, 40, 32], [14, 42, 34], [15, 47, 39], [16, 44, 36], [17, 48, 40],
      //   [18, 52, 44], [19, 54, 46], [20, 42, 34], [21, 55, 47], [22, 56, 48], [23, 57, 49],
      //   [24, 60, 52], [25, 50, 42], [26, 52, 44], [27, 51, 43], [28, 49, 41], [29, 53, 45],
      //   [30, 55, 47], [31, 60, 52], [32, 61, 53], [33, 59, 51], [34, 62, 54], [35, 65, 57],
      //   [36, 62, 54], [37, 58, 50], [38, 55, 47], [39, 61, 53], [40, 64, 56], [41, 65, 57],
      //   [42, 63, 55], [43, 66, 58], [44, 67, 59], [45, 69, 61], [46, 69, 61], [47, 70, 62],
      //   [48, 72, 64], [49, 68, 60], [50, 66, 58], [51, 65, 57], [52, 67, 59], [53, 70, 62],
      //   [54, 71, 63], [55, 72, 64], [56, 73, 65], [57, 75, 67], [58, 70, 62], [59, 68, 60],
      //   [60, 64, 56], [61, 60, 52], [62, 65, 57], [63, 67, 59], [64, 68, 60], [65, 69, 61],
      //   [66, 70, 62], [67, 72, 64], [68, 75, 67], [69, 80, 72]
      // ]);

//      data.addRows([
//        [0,0,0,0],[1,15,5,10]
//        ]);

      var options = {
        hAxis: {
          title: 'Time'
        },
        vAxis: {
          title: 'Popularity'
        },
        colors: ['#a52714', '#097138'],
        crosshair: {
          color: '#000',
          trigger: 'selection'
        }
      };

      var chart = new google.visualization.LineChart(document.getElementById('PdtCategorySalesMonthwise_chart_div1'));

      chart.draw(data, options);
//      chart.setSelection([{row: 38, column: 1}]);

    }