/**
 * Created by NTD on 6/5/2015.
 */

function convertTimeLiveScore(id) {
    try {
        var data = $('#' + id).text().trim().split('Z');
        var dataArr = data[0].split('T');
        var date = dataArr[0];
        var time = dataArr[1];
        var timeArr = time.split(':');
        var timeResult = timeArr[0] + ':' + timeArr[1];
        $('#' + id).html(timeResult);
    } catch (e) {

    }
}

function convertGoals(id) {
    var data = $('#' + id).text().trim();
    if (parseInt(data) < 0) {
        $('#' + id).html('?');
    }
}

function checkRowEvent(id) {
    var index = parseInt(id);
    if (index % 2 == 0) {
        $('#row-content-' + id).addClass('row-content-even');
    }
}
