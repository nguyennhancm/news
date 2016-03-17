/**
 * Created by NTD on 5/29/2015.
 */

function replaceContent(newId) {
    var title = $('#title_new-' + newId).text().trim();
    if (title.trim().length > 52) {
        title = title.substring(0, 52) + '...';
        $('#title_new-' + newId).html(title);
    }
    $('#title_new-' + newId).css('font-size', '13px');

    var contentFull = $('#contentFull-' + newId).text().trim();
    var idxImgView = contentFull.search('<img');
    var endIdxImgView = contentFull.search('/>');
    if (idxImgView > 0 && endIdxImgView > 0 && endIdxImgView > idxImgView) {
        var linkImg = contentFull.substring(idxImgView, endIdxImgView + 2);
        linkImg = linkImg.substring(0, 4) + ' class="img-index-not-responsive"  ' + linkImg.substring(4, linkImg.length);
        $('#img-view-index-' + newId).html(linkImg);
    }
    var idx = 0;
    idx = contentFull.indexOf('http');
    var idxImg = 0;
    idxImg = contentFull.indexOf('<img');
    if (idx > 0 && idxImg > 0) {
        if (idx > idxImg) {
            idx = idxImg
        }
    }
    var content;
    if (idx > 89) {
        content = contentFull.substring(0, 89) + '...';
    } else if (idx > 0 && idx < 89) {
        content = contentFull.substring(0, idx) + '...';
    } else {
        content = contentFull.substring(0, 89) + '...';
    }
    $('#subContent-' + newId).html(content);
    $('#subContent-' + newId).css('font-size', '11px');
}

function replaceContentSub(newId, type) {
    if (type == 'Horizontal') {
        var title = $('#title_new_horizontal-' + newId).text().trim();
        if (title.trim().length > 39) {
            title = title.substring(0, 39) + '...';
            $('#title_new_horizontal-' + newId).html(title);
        }
        $('#title_new_horizontal-' + newId).css('font-size', '11px');
        var contentFull = $('#contentHorizontalFull-' + newId).text().trim();
        var idxImgView = contentFull.search('<img');
        var endIdxImgView = contentFull.search('/>');
        if (idxImgView > 0 && endIdxImgView > 0 && endIdxImgView > idxImgView) {
            var linkImg = contentFull.substring(idxImgView, endIdxImgView + 2);
            linkImg = linkImg.substring(0, 4) + ' class="img-responsive"  ' + linkImg.substring(4, linkImg.length);
            $('#img_avatar_horizontal-' + newId).html(linkImg);
        }
    }else{
        var title = $('#title_new_vertical-' + newId).text().trim();
        if (title.trim().length > 39) {
            title = title.substring(0, 39) + '...';
            $('#title_new_vertical-' + newId).html(title);
        }
        $('#title_new_vertical-' + newId).css('font-size', '11px');
        var contentFull = $('#contentVerticalFull-' + newId).text().trim();
        var idxImgView = contentFull.search('<img');
        var endIdxImgView = contentFull.search('/>');
        if (idxImgView > 0 && endIdxImgView > 0 && endIdxImgView > idxImgView) {
            var linkImg = contentFull.substring(idxImgView, endIdxImgView + 2);
            linkImg = linkImg.substring(0, 4) + ' class="img-responsive"  ' + linkImg.substring(4, linkImg.length);
            $('#img_avatar_vertical-' + newId).html(linkImg);
        }
    }
}

function replaceContentVerticalList(newId) {
    var title = $('#titleNew-Vertical-' + newId).text().trim();
    if (title.trim().length > 39) {
        title = title.substring(0, 39) + '...';
        $('#titleNew-Vertical-' + newId).html(title);
    }
    $('#titleNew-Vertical-' + newId).css('font-size', '11px');
}

function replaceContentReview(newId) {
    var title = $('#content-review-' + newId).text().trim();
    var titleFix = title.split('<img');
    var sizeTitleFix = titleFix.length;
    var titleEnd = '';
    if (sizeTitleFix > 1) {
        for (var i = 0; i < sizeTitleFix; i++) {
            titleEnd += titleFix[i] + '<img class="img-responsive"'
        }
        $('#content-review-' + newId).html(titleEnd);
    } else
        $('#content-review-' + newId).html(title);
}
