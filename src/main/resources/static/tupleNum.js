google.charts.load('current', {'packages':['table']});
google.charts.setOnLoadCallback(drawTable);

var SellersDelay_Id = new Array();
var SellersDelay_para = new Array();
var countSellerDelay = 0;




function drawTable() 
{
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Table Name');
  data.addColumn('number', 'Tuple Number');


  var i = 0;
  for(i = 0; i < countSellerDelay; i++)
  {
    data.addRows([
      [SellersDelay_Id[i], SellersDelay_para[i]]
      ]);
  }


  var table = new google.visualization.Table(document.getElementById('table_div'));

  table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
}






