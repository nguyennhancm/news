/**
 * Created by NTD on 5/29/2015.
 */

function prepareUpload(event) {
    $('#click-lightbox').remove();
    var files = event.target.files;
    var totalFile = files.length;
    var relativePath = '2015';
    $.each(files, function (key, value) {
        var styleClass = Math.floor((Math.random() * 1000000000) + 1);
        appendProcessing(styleClass);
        var fileType = value.name.substr(value.name.indexOf(".") + 1, value.name.length).toLowerCase();
        var data = new FormData();
        data.append(key, value);
        data.append("relativePath", relativePath);
        data.append("styleClass", styleClass);
        data.append("fileType", fileType);
        sendToServlet(data, styleClass);
    });
}

function sendToServlet(data, styleClass) {
    jQuery.ajax({
        url: '/chatUploadImageServlet',
        type: 'POST',
        data: data,
        cache: false,
        dataType: 'json',
        processData: false, // Don't process the files
        contentType: false, // Set content type to false as jQuery will tell the server its a query string request
        success: function (data, textStatus, jqXHR) {
            if (typeof data.error === 'undefined') {
                // Success so call function to process the form
                $('#' + data.styleClass + 'process').progressbar({
                    value: 50
                });
                var step1 = setTimeout(function () {
                    $('#' + data.styleClass + 'process').progressbar({
                        value: 100
                    });
                }, 800);
                var step2 = setTimeout(function () {
                    $('#' + data.styleClass).html('' +
                    '<img onclick="choiceImage(event)" src="' + data.link + '" class="img-responsive"/>')
                    $('#' + data.styleClass + 'process').hide();
                    $('#' + data.styleClass).addClass('addToNewsContent')
                    $('#' + data.styleClass).attr('title', 'Thêm vào bài viết')
                }, 1100);
                var step3 = setTimeout(function () {
                    clearTimeout(step1);
                    clearTimeout(step2);
                    clearTimeout(step3);

                }, 3000);
            } else {

            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
            //TODO Send upload
        },
        complete: function (data) {
            if (data.statusText == 'OK') {
            } else {

            }
        }
    });
}

function appendProcessing(styleClass) {
    $('#uploadImageProcessing').append('' +
    '<div class="pull-left" style="margin-right: 3px;">' +
    '<div  id="' + styleClass + '" style="width: 90px; height: 70px;  border: 1px solid #f7f7f7;  background-color: #e9eaed;"> ' +
    '</div>' +
    '<div class="process_upload" id="' + styleClass + 'process' + '"></div>' +
    '</div>');
    $('#' + styleClass + 'process').progressbar({
        value: 5
    });
}

function choiceImage(event) {
    var linkImg = event.target.src;
    if (null != linkImg) {
        linkImg = '<div style="text-align: center;"><img  src="' + linkImg + '" class="img-responsive"></img></div>';
        CKEDITOR.instances.editorNews.insertHtml(linkImg);
    }
}