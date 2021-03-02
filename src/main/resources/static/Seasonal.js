// Load Charts and the corechart package.
google.charts.load('current', {'packages':['corechart']});

// Draw the pie chart for Sarah's pizza when Charts is loaded.
google.charts.setOnLoadCallback(drawOrderStatusChart);

// Draw the pie chart for the Anthony's pizza when Charts is loaded.
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawBasic);
google.charts.setOnLoadCallback(draweachBasic);

var orderStatus = new Array();
var orderOrders = new Array();
var count = 0;
var seasonal=new Array();
var eachseasonal=new Array();


// Callback that draws the pie chart for Sarah's pizza.
function drawOrderStatusChart() {


  
  
  // Create the data table for Sarah's pizza.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Topping');
  data.addColumn('number', 'Slices');
  var i;
  for(i = 0; i < count; i++)
  {
    data.addRows([[orderStatus[i], orderOrders[i]]]);
  }
  // data.addRows([
  //   ['Mushrooms', 1],
  //   ['Onions', 1],
  //   ['Olives', 2],
  //   ['Zucchini', 2],
  //   ['Pepperoni', 1]
  // ]);

  // Set options for Sarah's pie chart.
  var options = {title:'Order Status Information',
                  width:300,
                  height:200};

  // Instantiate and draw the chart for Sarah's pizza.
  var chart = new google.visualization.PieChart(document.getElementById('OrderStatus_chart_div'));
  chart.draw(data, options);
}


function drawBasic() {

      var data = new google.visualization.DataTable();
      data.addColumn('string', 'Season');
      data.addColumn('number', 'Total Revenue');
      data.addColumn('number', 'Total Order');

       for(var i=0;i<seasonal.length;i++){
    	   
    	  data.addRows([[seasonal[i].year+seasonal[i].season,seasonal[i].total/100,seasonal[i].count]]);
       }
      

      var options = {
        hAxis: {
          title: 'Season'
        },
        vAxis: {
          title: 'Orders'
        },
        width: 1300,
        height: 500
      };

      var chart = new google.visualization.LineChart(document.getElementById('Anthony_chart_div'));

      chart.draw(data, options);
    }

function draweachBasic(){
	var data = new google.visualization.DataTable();
    data.addColumn('string', 'Season');
    data.addColumn('number', 'sports_leisure');
    data.addColumn('number', 'furniture_decor');
    data.addColumn('number', 'health_beauty');
    data.addColumn('number', 'baby');
    data.addColumn('number', 'stationery');
    data.addColumn('number', 'electronics');
    data.addColumn('number', 'air_conditioning');
    var tempdata=new Array();
    for(var k=0;k<8;k++)
 	 {tempdata[k]=0}
    tempdata[2]=2;
     for(var i=1;i<eachseasonal.length;i++){
    	 
  	     if(eachseasonal[i-1].year+eachseasonal[i-1].season==eachseasonal[i].year+eachseasonal[i].season){
  	    	 for(var j=0;j<8;j++){
  	    		if(data.getColumnLabel(j)==eachseasonal[i].product_category_name_english){
  	    			tempdata[j]=eachseasonal[i].total;
  	    		}
  	    	 }
         
  	     }
  	     else{
  	    	tempdata[0]=eachseasonal[i-1].year+eachseasonal[i-1].season;
  	    	data.addRows([tempdata]);
  	    	 var tempdata=new Array();
  	    	 for(var k=0;k<8;k++)
  	    	 {tempdata[k]=0}
  	     }

  	    
     }
    

    var options = {
      hAxis: {
        title: 'Season'
      },
      vAxis: {
        title: 'Orders'
      },
      width: 1300,
      height: 500
    };

    var chart = new google.visualization.LineChart(document.getElementById('each_chart_div'));

    chart.draw(data, options);
	
}
// Callback that draws the pie chart for Anthony's pizza.
function drawAnthonyChart() {

  // Create the data table for Anthony's pizza.
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Topping');
  data.addColumn('number', 'Slices');
  data.addRows(
    [['Mushrooms', 2]]
  );

  data.addRows(
    [['Onions', 2]]
    );

  // Set options for Anthony's pie chart.
  var options = {title:'How Much Pizza Anthony Ate Last Night',
                  width:300,
                  height:200};

  // Instantiate and draw the chart for Anthony's pizza.
  //var chart = new google.visualization.PieChart(document.getElementById('Anthony_chart_div'));
  chart.draw(data, options);
}




