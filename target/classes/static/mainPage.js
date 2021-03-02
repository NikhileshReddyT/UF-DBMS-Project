// Load Charts and the corechart package.
google.charts.load('current', {'packages':['corechart']});

// Draw the pie chart for Sarah's pizza when Charts is loaded.
google.charts.setOnLoadCallback(drawOrderStatusChart);


google.charts.load('current', {'packages':['gauge']});
google.charts.setOnLoadCallback(drawdashChart);

var orderStatus = new Array();
var orderOrders = new Array();
var count = 0;

var repeatrate;
var order;
var ReviewScore;


function drawdashChart() {


console.log(repeatrate);
      console.log(order);
      console.log(ReviewScore);

  var data = google.visualization.arrayToDataTable([
    ['Label', 'Value'],
    ['Repeat Rate', repeatrate],
  ]);
  var data1 = google.visualization.arrayToDataTable([
      ['Label', 'Value'],
      ['Orders', order],
    ]);

  var data2 = google.visualization.arrayToDataTable([
      ['Label', 'Value'],
      ['Average Score', ReviewScore],
    ]);

  var options = {
    width: 800, height: 240,
    redFrom: 0, redTo: 4,
    yellowFrom:4, yellowTo: 12,
    min:0,max:20,
    minorTicks: 5
  };
  
  var options1 = {
        width: 800, height: 240,
        redFrom: 0, redTo: 50000,
        yellowFrom:50000, yellowTo: 120000,
        min:0,max:200000,
        minorTicks: 5
      };

  var options2 = {
        width: 800, height: 240,
        redFrom: 0, redTo: 2,
        yellowFrom:2, yellowTo: 4,
        min:0,max:5,
        minorTicks: 5
      };



  var chart = new google.visualization.Gauge(document.getElementById('gauge_chart_div'));
  chart.draw(data, options);
  
  var chart1 = new google.visualization.Gauge(document.getElementById('gauge_chart_div2'));
  chart1.draw(data1, options1);

  var chart2 = new google.visualization.Gauge(document.getElementById('gauge_chart_div3'));
  chart2.draw(data2, options2);

}


// Callback that draws the pie chart for order status
function drawOrderStatusChart() {
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Topping');
  data.addColumn('number', 'Slices');
  var i;
  for(i = 0; i < count; i++)
  {
    if(orderStatus[i]!='delivered'){
    data.addRows([[orderStatus[i], orderOrders[i]]]);
    }
  }

  // Set options for Sarah's pie chart.
  var options = {title:'Order Status Information',
                  width:1000,
                  height:400,
                  is3D: true,
                  legend: { position: 'labeled', textStyle: {color: 'black', fontSize: 20} }
                  };

  // Instantiate and draw the chart for Sarah's pizza.
  var chart = new google.visualization.PieChart(document.getElementById('OrderStatus_chart_div'));
  chart.draw(data, options);
}






