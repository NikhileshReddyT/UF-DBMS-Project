google.charts.load('current', {'packages':['table']});
google.charts.setOnLoadCallback(drawTable);
google.charts.load('current', {packages: ['corechart', 'line']});
google.charts.setOnLoadCallback(drawCrosshairs);

var SellersDelay_Id = new Array();
var SellersDelay_para = new Array();
var SellersDelay_delayCount = new Array();
var SelersDelay_delayTime = new Array();
var countSellerDelay = 0;

var ProductDelay_year = new Array();
var ProductDelay_month = new Array();
var ProductDelay_percentage = new Array();
var countProductDelay = 0;


function drawTable() 
{
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Sellers Id');
  data.addColumn('number', 'Parameter');
  data.addColumn('number', 'Delay order number');
  data.addColumn('number', 'Average delay time');

  var i = 0;
  for(i = 0; i < countSellerDelay; i++)
  {
    data.addRows([
      [SellersDelay_Id[i], SellersDelay_para[i], SellersDelay_delayCount[i], SelersDelay_delayTime[i]]
      ]);
  }


  var table = new google.visualization.Table(document.getElementById('table_div'));

  table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
}

function drawCrosshairs() {
      var data = new google.visualization.DataTable();
      data.addColumn('number', 'Month');
      data.addColumn('number', '2017');
      data.addColumn('number', '2018');

      var i = 0;

      for(i = 2; i < 14; i++)
      {
        if(i >= 2 && i <= 9)
          data.addRows([
          [ProductDelay_month[i], ProductDelay_percentage[i], ProductDelay_percentage[i + 12]]
          ]);
        else
          data.addRows([
          [ProductDelay_month[i], ProductDelay_percentage[i], 0]
          ]);
      }
      


      var options = {
        hAxis: {
          title: 'Month'
        },
        vAxis: {
          title: 'Delay Precentage'
        },
        colors: ['#00ff00', '#ff0000', '#0000ff'],
        crosshair: {
          color: '#000',
          trigger: 'selection'
        },
        width:1200,
        height:700
      };

      var chart = new google.visualization.LineChart(document.getElementById('lineChart_div'));

      chart.draw(data, options);
      chart.setSelection([{row: 38, column: 1}]);

    }




