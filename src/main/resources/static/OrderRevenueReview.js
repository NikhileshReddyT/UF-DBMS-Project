// Load Charts and the corechart package.
google.charts.load('current', {'packages':['corechart']});

// Draw the pie chart for Sarah's pizza when Charts is loaded.


// Draw the pie chart for the Anthony's pizza when Charts is loaded.
google.charts.load('current', {packages: ['corechart', 'line']});

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




function draweachBasic(){
//	var data = new google.visualization.DataTable();
//    data.addColumn('string', 'Season');
//    data.addColumn('number', 'sports_leisure');
//    data.addColumn('number', 'furniture_decor');
//    data.addColumn('number', 'health_beauty');
//    data.addColumn('number', 'baby');
//    data.addColumn('number', 'stationery');
//    data.addColumn('number', 'electronics');
//    data.addColumn('number', 'air_conditioning');
//    var tempdata=new Array();
//    for(var k=0;k<8;k++)
// 	 {tempdata[k]=0}
//    tempdata[2]=2;
//     for(var i=1;i<eachseasonal.length;i++){
//    	 
//  	     if(eachseasonal[i-1].year+eachseasonal[i-1].season==eachseasonal[i].year+eachseasonal[i].season){
//  	    	 for(var j=0;j<8;j++){
//  	    		if(data.getColumnLabel(j)==eachseasonal[i].product_category_name_english){
//  	    			tempdata[j]=eachseasonal[i].total;
//  	    		}
//  	    	 }
//         
//  	     }
//  	     else{
//  	    	tempdata[0]=eachseasonal[i-1].year+eachseasonal[i-1].season;
//  	    	data.addRows([tempdata]);
//  	    	 var tempdata=new Array();
//  	    	 for(var k=0;k<8;k++)
//  	    	 {tempdata[k]=0}
//  	     }
//
//  	    
//     }
//    
//
//    var options = {
//      hAxis: {
//        title: 'Season'
//      },
//      vAxis: {
//        title: 'Orders'
//      },
//      width: 1300,
//      height: 500
//    };
//
//    var chart = new google.visualization.LineChart(document.getElementById('each_chart_div'));
//
//    chart.draw(data, options);
    var data = new google.visualization.DataTable();
    var tempseason=new Array();
    data.addColumn('string', 'Product Category');
    data.addColumn('number', 'Revenue');
    data.addColumn('number', 'Order');
    data.addColumn('number', 'Rating');
    data.addColumn('number', 'Rating');
    for(var i=0;i<seasonal.length ;i++){
    	if(seasonal[i].revenue>200000 ||seasonal[i].orders>4000 ){
    data.addRow([seasonal[i].product_category_name_english,seasonal[i].revenue,seasonal[i].orders,seasonal[i].rating,seasonal[i].rating]);
    	}else{
    		tempseason.push(seasonal[i]);
    	}
    }
//    var data = google.visualization.arrayToDataTable([
//        ['ID', 'Life Expectancy', 'Fertility Rate', 'Region',     'Population'],
//        ['CAN',    80.66,              1.67,      'North America',  33739900],
//        ['DEU',    79.84,              1.36,      'Europe',         81902307],
//        ['DNK',    78.6,               1.84,      'Europe',         5523095],
//        ['EGY',    72.73,              2.78,      'Middle East',    79716203],
//        ['GBR',    80.05,              2,         'Europe',         61801570],
//        ['IRN',    72.49,              1.7,       'Middle East',    73137148],
//        ['IRQ',    68.09,              4.77,      'Middle East',    31090763],
//        ['ISR',    81.55,              2.96,      'Middle East',    7485600],
//        ['RUS',    68.6,               1.54,      'Europe',         141850000],
//        ['USA',    78.09,              2.05,      'North America',  307007000]
//      ]);

      var options = {
        title: 'Correlation between Total Revenue, Total Orders ' +
               'and Rating of some HIGH REVENUE Product Categories',
        hAxis: {title: 'Total Revenue'},
        vAxis: {title: 'Total Orders'},
        bubble: {textStyle: {fontSize: 11}},
        animation:{startup: true ,easing: 'out'},
        width: 1300,
        height: 500
        };

      var chart = new google.visualization.BubbleChart(document.getElementById('bubble_chart'));
      chart.draw(data, options);
      var data1 = new google.visualization.DataTable();
      var data2=new google.visualization.DataTable();
      data1.addColumn('string', 'Product Category');
      data1.addColumn('number', 'Revenue');
      data1.addColumn('number', 'Order');
      data1.addColumn('number', 'Rating');
      data1.addColumn('number', 'Rating');
      data2.addColumn('string', 'Product Category');
      data2.addColumn('number', 'Revenue');
      data2.addColumn('number', 'Order');
      data2.addColumn('number', 'Rating');
      data2.addColumn('number', 'Rating');
      
      for(var i=0;i<tempseason.length ;i++){
      	if(tempseason[i].revenue>20000 && tempseason[i].revenue<80000){
      data1.addRow([tempseason[i].product_category_name_english,tempseason[i].revenue,tempseason[i].orders,tempseason[i].rating,tempseason[i].rating]);
      	}else if(tempseason[i].revenue<3000)
      		{
            data2.addRow([tempseason[i].product_category_name_english,tempseason[i].revenue,tempseason[i].orders,tempseason[i].rating,tempseason[i].rating]);

      		}
      		
      	
      }
      var options1 = {
    	        title: 'Correlation between Total Revenue, Total Orders ' +
    	               'and Rating of MEDIUM REVENUE Product Categories',
    	        hAxis: {title: 'Total Revenue'},
    	        vAxis: {title: 'Total Orders'},
    	        bubble: {textStyle: {fontSize: 11}},
    	        animation:{"startup": true },
    	        width: 1300,
    	        height: 500
    	        };
      
      var options2 = {
  	        title: 'Correlation between Total Revenue, Total Orders ' +
  	               'and Rating of LOW REVENUE Product Categories',
  	        hAxis: {title: 'Total Revenue'},
  	        vAxis: {title: 'Total Orders'},
  	        bubble: {textStyle: {fontSize: 11}},
  	        animation:{startup: 1 },
  	        width: 1300,
  	        height: 500
  	        };
      var chart = new google.visualization.BubbleChart(document.getElementById('bubble_chart2'));
      chart.draw(data1, options1);
      var chart2 = new google.visualization.BubbleChart(document.getElementById('bubble_chart3'));
      chart2.draw(data2, options2);

	
}





