/*
 * HTML5 Audio Player PRO - v1.8.2
 *
 * Copyright 2014, LambertGroup
 * 
 */

(function (e) {
    function L(a) {
        a = document.getElementById(a.audioID);
        return!(!a.canPlayType || !a.canPlayType("audio/mpeg;").replace(/no/, ""))
    }

    function P(a, c, f, d, g, n, p, v, l, z, m, t, E, q) {
        if(a.origID == undefined){
            a.origID = 0;
        }
        a.totalTime = "Infinity";
        c.isSliderInitialized && (n.slider("destroy"), c.isSliderInitialized = !1);
        c.isProgressInitialized && (p.progressbar("destroy"), c.isProgressInitialized = !1);
        a.is_changeSrc = !0;
        a.is_buffer_complete = !1;
        z.width(a.titleWidth);
        t.width(a.titleWidth);
        p.css({background: c.bufferEmptyColor});
        a.curSongText = "";
        c.showTitle && null != a.playlist_arr[a.origID].title && "" != a.playlist_arr[a.origID].title && (a.curSongText += a.playlist_arr[a.origID].title);
        a.isAuthorTitleInsideScrolling = !1;
        a.authorTitleInsideWait = 0;
        m.stop();
        m.css({"margin-left": 0});
        m.html(a.curSongText);
        c.showAuthor && null != a.playlist_arr[a.origID].author && "" != a.playlist_arr[a.origID].author && t.html(a.playlist_arr[a.origID].author);
        q.html('<img src="' + a.playlist_arr[a.origID].image + '" width="80">');
        a.curSongText || z.css({display: "none", width: 0, height: 0, padding: 0, margin: 0});
        e(a.thumbsHolder_Thumbs[a.current_img_no]).css({background: c.playlistRecordBgOnColor, "border-bottom-color": c.playlistRecordBottomBorderOnColor, color: c.playlistRecordTextOnColor});
        a.is_very_first || J(-1, a, c, f);
        f = a.playlist_arr[a.origID].sources_mp3;
        if (-1 != k.indexOf("opera") || -1 != k.indexOf("firefox") || -1 != k.indexOf("mozzila"))f = a.playlist_arr[a.origID].sources_ogg, "" != L(a) && (f = a.playlist_arr[a.origID].sources_mp3);
        if (-1 != k.indexOf("chrome") || -1 != k.indexOf("msie") || -1 != k.indexOf("safari"))f = a.playlist_arr[a.origID].sources_mp3, -1 != k.indexOf("opr") && (f = a.playlist_arr[a.current_img_no].sources_ogg, "" != L(a) && (f = a.playlist_arr[a.origID].sources_mp3));
        -1 != k.indexOf("android") && (f = a.playlist_arr[a.origID].sources_mp3);
        if (-1 != k.indexOf("ipad") || -1 != k.indexOf("iphone") || -1 != k.indexOf("ipod") || -1 != k.indexOf("webos"))f = a.playlist_arr[a.origID].sources_mp3;
        document.getElementById(a.audioID).src = f;
        document.getElementById(a.audioID).load();
        c.googleTrakingOn && ga("send", "event", "Audio Files", "Play", "Title: " + a.playlist_arr[a.origID].title + " --- File: " + f);
        -1 != k.indexOf("android") || (-1 != k.indexOf("ipad") || -1 != k.indexOf("iphone") || -1 != k.indexOf("ipod") || -1 != k.indexOf("webos")) && a.is_very_first || (c.autoPlay ? (Q(), document.getElementById(a.audioID).play(), g.addClass("AudioPause")) : g.removeClass("AudioPause"))
    }

    function G(a) {
        var c = 10 > Math.floor(a / 60) ? "0" + Math.floor(a / 60) : Math.floor(a / 60);
        return c + ":" + (10 > Math.floor(a - 60 * c) ? "0" + Math.floor(a - 60 * c) : Math.floor(a - 60 * c))
    }

    function R(a, c, f, d, g, n, p, k, l) {
        a.is_changeSrc = !1;
        a.is_very_first && (a.is_very_first = !1);
        g.width(c.playerWidth - 2 * a.timerLeftPos - 2 * n.width() - 2 * a.seekBarLeftRightSpacing);
        a.bufferTopPos = a.timerTopPos + parseInt((n.height() - g.height()) / 2, 10);
        a.bufferLeftPos = parseInt((f.width() - g.width()) / 2);
        g.css({top: a.bufferTopPos + "px", left: a.bufferLeftPos + "px"});
        d.width(g.width());
        d.css({top: a.bufferTopPos + "px", left: a.bufferLeftPos + "px"});
        d.slider({value: 0, step: .01, orientation: "horizontal", range: "min", max: a.totalTime, slide: function () {
            a.is_seeking = !0
        }, stop: function (c, d) {
            a.is_seeking = !1;
            document.getElementById(a.audioID).currentTime = d.value;
            0 != document.getElementById(a.audioID).paused && (document.getElementById(a.audioID).play(), k.addClass("AudioPause"))
        }, create: function (a, d) {
            c.isSliderInitialized = !0
        }});
        e(".ui-slider-range", d).css({background: c.seekbarColor});
        g.progressbar({value: 0, complete: function () {
            a.is_buffer_complete = !0
        }, create: function (a, d) {
            c.isProgressInitialized = !0
        }});
        e(".ui-widget-header", g).css({background: c.bufferFullColor})
    }

    function W(a, c, e, d, g, n, p, v, l, z, m) {
        !a.isAuthorTitleInsideScrolling && 5 <= a.authorTitleInsideWait && m.width() > a.titleWidth ? (a.isAuthorTitleInsideScrolling = !0, a.authorTitleInsideWait = 0, m.html(a.curSongText + " **** " + a.curSongText + " **** " + a.curSongText + " **** " + a.curSongText + " **** " + a.curSongText + " **** "), m.css({"margin-left": 0}), m.stop().animate({"margin-left": c.playerWidth - m.width() + "px"}, parseInt(1E4 * (m.width() - c.playerWidth) / 150, 10), "linear", function () {
            a.isAuthorTitleInsideScrolling = !1
        })) : !a.isAuthorTitleInsideScrolling && m.width() > a.titleWidth && a.authorTitleInsideWait++;
        curTime = document.getElementById(a.audioID).currentTime;
        bufferedTime = 0;
        a.is_changeSrc && !isNaN(a.totalTime) && "Infinity" != a.totalTime && (R(a, c, e, d, g, n, p, v, l), -1 != k.indexOf("android") && (c.autoPlay ? (document.getElementById(a.audioID).play(), v.addClass("AudioPause")) : v.removeClass("AudioPause")));
        !a.is_seeking && c.isSliderInitialized && d.slider("value", curTime);
        -1 != k.indexOf("android") ? (a.totalTime != document.getElementById(a.audioID).duration && 0 < document.getElementById(a.audioID).duration && (a.totalTime = document.getElementById(a.audioID).duration, c.isSliderInitialized && (d.slider("destroy"), c.isSliderInitialized = !1), c.isProgressInitialized && (g.progressbar("destroy"), c.isProgressInitialized = !1), R(a, c, e, d, g, n, p, v, l)), g.css({background: c.bufferFullColor}), isNaN(a.totalTime) || "Infinity" == a.totalTime ? (n.text("00:00"), p.text(G(0))) : (n.text(G(curTime)), p.text(G(a.totalTime)))) : (document.getElementById(a.audioID).buffered.length && (bufferedTime = document.getElementById(a.audioID).buffered.end(document.getElementById(a.audioID).buffered.length - 1), 0 < bufferedTime && !a.is_buffer_complete && !isNaN(a.totalTime) && "Infinity" != a.totalTime && c.isProgressInitialized && g.progressbar({value: 100 * bufferedTime / a.totalTime})), n.text(G(curTime)), p.text(G(bufferedTime)))
    }

    function J(a, c, e, d) {
        var g = (c.thumbsHolder_ThumbHeight + 1) * (c.selectedCateg_total_images - e.numberOfThumbsPerScreen);
        d.stop(!0, !0);
        -1 == a || c.isCarouselScrolling ? !c.isCarouselScrolling && c.selectedCateg_total_images > e.numberOfThumbsPerScreen && (c.isCarouselScrolling = !0, a = -1 * parseInt((c.thumbsHolder_ThumbHeight + 1) * c.current_img_no, 10), Math.abs(a) > g && (a = -1 * g), c.selectedCateg_total_images > e.numberOfThumbsPerScreen && e.showPlaylist && c.audio2_html5_sliderVertical.slider("value", 100 + parseInt(100 * a / g)), d.animate({top: a + "px"}, 690, "easeOutCubic", function () {
            c.isCarouselScrolling = !1
        })) : (c.isCarouselScrolling = !0, d.animate({top: (2 >= a ? -1 * g : parseInt(g * (a - 100) / 100, 10)) + "px"}, 1100, "easeOutQuad", function () {
            c.isCarouselScrolling = !1
        }))
    }

    function X(a, c, f, d, g, n, k, v, l, z, m, t, E, q, A, w, B, y, D, u) {
        d.stop(!0, !0);
        a.isCarouselScrolling = !1;
        d.stop().animate({left: -1 * n.width() + "px"}, 600, "easeOutQuad", function () {
            d.html("");
            for (var h = 0; h < a.category_arr.length; h++)a.thumbsHolder_Thumb = e('<div class="thumbsHolder_ThumbOFF" rel="' + h + '"><div class="padding">' + a.category_arr[h] + "</div></div>"), d.append(a.thumbsHolder_Thumb), a.thumbsHolder_Thumb.css({top: (a.thumbsHolder_Thumb.height() + 1) * h + "px", background: c.categoryRecordBgOffColor, "border-bottom-color": c.categoryRecordBottomBorderOffColor, color: c.categoryRecordTextOffColor}), a.category_arr[h] == a.selectedCateg && (a.current_img_no = h, a.thumbsHolder_Thumb.css({background: c.categoryRecordBgOnColor, "border-bottom-color": c.categoryRecordBottomBorderOnColor, color: c.categoryRecordTextOnColor}));
            a.selectedCateg_total_images = a.numberOfCategories;
            a.categsAreListed = !0;
            g.height(2 * c.playlistPadding + (a.thumbsHolder_Thumb.height() + 1) * c.numberOfThumbsPerScreen + k.height() + l.height() + 2 * c.selectedCategMarginBottom);
            n.height((a.thumbsHolder_Thumb.height() + 1) * c.numberOfThumbsPerScreen);
            z.css({padding: c.playlistPadding + "px"});
            a.thumbsHolder_Thumbs = e(".thumbsHolder_ThumbOFF", f);
            a.numberOfCategories > c.numberOfThumbsPerScreen && c.showPlaylist ? (c.isPlaylistSliderInitialized && a.audio2_html5_sliderVertical.slider("destroy"), a.audio2_html5_sliderVertical.slider({orientation: "vertical", range: "min", min: 1, max: 100, step: 1, value: 100, slide: function (e, f) {
                J(f.value, a, c, d)
            }}), c.isPlaylistSliderInitialized = !0, a.audio2_html5_sliderVertical.css({display: "inline", position: "absolute", height: g.height() - 20 - k.height() - 2 * c.selectedCategMarginBottom - l.height() - 2 * c.playlistPadding + "px", left: f.width() + 2 * c.playerPadding - a.audio2_html5_sliderVertical.width() - c.playlistPadding + "px", top: a.audioPlayerHeight + c.playlistTopPos + c.playlistPadding + k.height() + c.selectedCategMarginBottom + 2 + "px"}), c.showPlaylistOnInit || a.audio2_html5_sliderVertical.css({opacity: 0, display: "none"}), c.showPlaylistOnInit = !0, e(".thumbsHolder_ThumbOFF", f).css({width: f.width() + 2 * c.playerPadding - a.audio2_html5_sliderVertical.width() - 2 * c.playlistPadding - 3 + "px"})) : (c.isPlaylistSliderInitialized && (a.audio2_html5_sliderVertical.slider("destroy"), c.isPlaylistSliderInitialized = !1), e(".thumbsHolder_ThumbOFF", f).css({width: f.width() + 2 * c.playerPadding - 2 * c.playlistPadding + "px"}));
            a.thumbsHolder_Thumbs.click(function () {
                var h = e(this).attr("rel");
                a.selectedCateg = a.category_arr[h];
                v.html(a.selectedCateg);
                S(a, c, f, d, g, n, k, l, z, m, t, E, q, A, w, B, y, D, u)
            });
            a.thumbsHolder_Thumbs.mouseover(function () {
                e(this).css({background: c.categoryRecordBgOnColor, "border-bottom-color": c.categoryRecordBottomBorderOnColor, color: c.categoryRecordTextOnColor})
            });
            a.thumbsHolder_Thumbs.mouseout(function () {
                var d = e(this), f = d.attr("rel");
                a.current_img_no != f && d.css({background: c.categoryRecordBgOffColor, "border-bottom-color": c.categoryRecordBottomBorderOffColor, color: c.categoryRecordTextOffColor})
            });
            n.mousewheel(function (e, f, g, b) {
                e.preventDefault();
                e = a.audio2_html5_sliderVertical.slider("value");
                if (1 < parseInt(e) && -1 == parseInt(f) || 100 > parseInt(e) && 1 == parseInt(f))e += f, a.audio2_html5_sliderVertical.slider("value", e), J(e, a, c, d)
            });
            d.css({top: "0px"});
            d.stop().animate({left: "0px"}, 400, "easeOutQuad", function () {
            })
        })
    }

    function S(a, c, f, d, g, k, p, v, l, z, m, t, E, q, A, w, B, y, D) {
        d.stop(!0, !0);
        a.isCarouselScrolling = !1;
        var u = "", h = !1, x = 690;
        a.is_very_first && (x = 1);
        "" != a.search_val && (x = 1);
        d.stop().animate({left: -1 * k.width() + "px"}, x, "easeOutQuad", function () {
            d.html("");
            for (var r = a.selectedCateg_total_images = 0; r < a.playlist_arr.length; r++)h = !1, "" != a.search_val ? (u = a.playlist_arr[r].title.toLowerCase(), -1 != u.indexOf(a.search_val) && (h = !0)) : -1 != a.playlist_arr[r].category.indexOf(a.selectedCateg + ";") && (h = !0), h && (a.selectedCateg_total_images++, a.thumbsHolder_Thumb = e('<div class="thumbsHolder_ThumbOFF" rel="' + (a.selectedCateg_total_images - 1) + '" data-origID="' + r + '"><div class="padding">' + (c.showPlaylistNumber ? a.selectedCateg_total_images + ". " : "") + a.playlist_arr[r].title + "</div></div>"), d.append(a.thumbsHolder_Thumb), 0 == a.thumbsHolder_ThumbHeight && (a.thumbsHolder_ThumbHeight = a.thumbsHolder_Thumb.height()), a.thumbsHolder_Thumb.css({top: (a.thumbsHolder_ThumbHeight + 1) * a.selectedCateg_total_images + "px", background: c.playlistRecordBgOffColor, "border-bottom-color": c.playlistRecordBottomBorderOffColor, color: c.playlistRecordTextOffColor}), a.current_img_no = 0, a.origID == e("div[rel='" + (a.selectedCateg_total_images - 1) + "']").attr("data-origID") && a.thumbsHolder_Thumb.css({background: c.playlistRecordBgOnColor, "border-bottom-color": c.playlistRecordBottomBorderOnColor, color: c.playlistRecordTextOnColor}));
            a.categsAreListed = !1;
            g.height(2 * c.playlistPadding + (a.thumbsHolder_ThumbHeight + 1) * c.numberOfThumbsPerScreen + p.height() + v.height() + 2 * c.selectedCategMarginBottom);
            k.height((a.thumbsHolder_ThumbHeight + 1) * c.numberOfThumbsPerScreen);
            l.css({padding: c.playlistPadding + "px"});
            a.thumbsHolder_Thumbs = e(".thumbsHolder_ThumbOFF", f);
            a.selectedCateg_total_images > c.numberOfThumbsPerScreen && c.showPlaylist ? (c.isPlaylistSliderInitialized && a.audio2_html5_sliderVertical.slider("destroy"), a.audio2_html5_sliderVertical.slider({orientation: "vertical", range: "min", min: 1, max: 100, step: 1, value: 100, slide: function (e, b) {
                J(b.value, a, c, d)
            }}), c.isPlaylistSliderInitialized = !0, a.audio2_html5_sliderVertical.css({display: "inline", position: "absolute", height: g.height() - 20 - p.height() - 2 * c.selectedCategMarginBottom - v.height() - 2 * c.playlistPadding + "px", left: f.width() + 2 * c.playerPadding - a.audio2_html5_sliderVertical.width() - c.playlistPadding + "px", top: a.audioPlayerHeight + c.playlistTopPos + c.playlistPadding + p.height() + c.selectedCategMarginBottom + 2 + "px"}), c.showPlaylistOnInit || a.audio2_html5_sliderVertical.css({opacity: 0, display: "none"}), c.showPlaylistOnInit = !0, e(".thumbsHolder_ThumbOFF", f).css({width: f.width() + 2 * c.playerPadding - a.audio2_html5_sliderVertical.width() - 2 * c.playlistPadding - 3 + "px"})) : (c.isPlaylistSliderInitialized && (a.audio2_html5_sliderVertical.slider("destroy"), c.isPlaylistSliderInitialized = !1), e(".thumbsHolder_ThumbOFF", f).css({width: f.width() + 2 * c.playerPadding - 2 * c.playlistPadding + "px"}));
            a.thumbsHolder_Thumbs.click(function () {
                if (!a.is_changeSrc) {
                    c.autoPlay = !0;
                    var g = e(this).attr("rel");
                    a.thumbsHolder_Thumbs.css({background: c.playlistRecordBgOffColor, "border-bottom-color": c.playlistRecordBottomBorderOffColor, color: c.playlistRecordTextOffColor});
                    a.current_img_no = g;
                    a.origID = e("div[rel='" + a.current_img_no + "']").attr("data-origID");
                    P(a, c, d, f, z, m, t, E, q, A, w, B, y, D)
                }
            });
            a.thumbsHolder_Thumbs.mouseover(function () {
                e(this).css({background: c.playlistRecordBgOnColor, "border-bottom-color": c.playlistRecordBottomBorderOnColor, color: c.playlistRecordTextOnColor})
            });
            a.thumbsHolder_Thumbs.mouseout(function () {
                var d = e(this), b = d.attr("rel");
                a.origID != e("div[rel='" + b + "']").attr("data-origID") && d.css({background: c.playlistRecordBgOffColor, "border-bottom-color": c.playlistRecordBottomBorderOffColor, color: c.playlistRecordTextOffColor})
            });
            k.mousewheel(function (e, b, f, g) {
                e.preventDefault();
                e = a.audio2_html5_sliderVertical.slider("value");
                if (1 < parseInt(e) && -1 == parseInt(b) || 100 > parseInt(e) && 1 == parseInt(b))e += b, a.audio2_html5_sliderVertical.slider("value", e), J(e, a, c, d)
            });
            d.css({top: "0px"});
            d.stop().animate({left: "0px"}, 400, "easeOutQuad", function () {
            })
        })
    }

    function V(a, c, f) {
        c.shuffle ? (c = Math.floor(Math.random() * (a.selectedCateg_total_images - 1)), a.current_img_no = c != a.current_img_no ? c : Math.floor(Math.random() * (a.selectedCateg_total_images - 1))) : "next" == f ? a.current_img_no == a.selectedCateg_total_images - 1 ? a.current_img_no = 0 : a.current_img_no++ : 0 > a.current_img_no - 1 ? a.current_img_no = a.selectedCateg_total_images - 1 : a.current_img_no--;
        a.origID = e("div[rel='" + a.current_img_no + "']").attr("data-origID")
    }

    function Y() {
        var a = -1;
        "Microsoft Internet Explorer" == navigator.appName && null != /MSIE ([0-9]{1,}[.0-9]{0,})/.exec(navigator.userAgent) && (a = parseFloat(RegExp.$1));
        return parseInt(a, 10)
    }

    function Q() {
        e("audio").each(function () {
            e(".AudioPlay").removeClass("AudioPause");
            e(this)[0].pause()
        })
    }

    var k = navigator.userAgent.toLowerCase();
    e.fn.audio2_html5 = function (a) {
        a = e.extend({}, e.fn.audio2_html5.defaults, a);
        return this.each(function () {
            var c = e(this), f = e('<div class="AudioControls"> <a class="AudioRewind" title="Rewind"></a><a class="AudioShuffle" title="Shuffle Playlist"></a><a class="AudioDownload" title="Download File"></a><a class="AudioFacebook" title="Facebook"></a><a class="AudioTwitter" title="Twitter"></a><a class="AudioPlay" title="Play/Pause"></a><a class="AudioPrev" title="Previous"></a><a class="AudioNext" title="Next"></a><a class="AudioShowHidePlaylist" title="Show/Hide Playlist"></a><a class="VolumeButton" title="Mute/Unmute"></a><div class="VolumeSlider"></div> <div class="AudioTimer_a">00:00</div><div class="AudioTimer_b">00:00</div> </div> <div class="AudioBuffer"></div><div class="AudioSeek"></div><div class="songTitle"><div class="songTitleInside"></div></div> <div class="songAuthor"></div> <div class="bordersDiv"></div> <div class="thumbsHolderWrapper"><div class="playlistPadding"><div class="selectedCategDiv"><div class="innerSelectedCategDiv">CATEGORIES</div></div> <div class="thumbsHolderVisibleWrapper"><div class="thumbsHolder"></div></div><div class="searchDiv"><input class="search_term" type="text" value="Tìm kiếm..." /></div></div></div> <div class="slider-vertical"></div> <div class="ximage"></div> <div class="bordersDiv"></div> '), d = c.parent(".audio2_html5");
            d.addClass(a.skin);
            d.append(f);
            e(".AudioControls", d);
            var f = e(".AudioRewind", d), g = e(".AudioShuffle", d), n = e(".AudioDownload", d), p = e(".AudioFacebook", d), v = e(".AudioTwitter", d), l = e(".AudioPlay", d), z = e(".AudioPrev", d), m = e(".AudioNext", d), t = e(".bordersDiv", d), E = e(".AudioShowHidePlaylist", d), q = e(".VolumeButton", d), A = e(".VolumeSlider", d), w = e(".AudioTimer_a", d), B = e(".AudioTimer_b", d), y = e(".songTitle", d), D = e(".songTitleInside", d), u = e(".songAuthor", d), h = e(".ximage", d), x = e(".AudioBuffer", d), r = e(".AudioSeek", d), G = Y();
            d.css({background: a.playerBg, padding: a.playerPadding + "px"});
            var b = {current_img_no: 0, origID: 0, is_very_first: !0, total_images: 0, selectedCateg_total_images: 0, numberOfCategories: 0, is_seeking: !1, is_changeSrc: !1, is_buffer_complete: !1, timeupdateInterval: "", totalTime: "", playlist_arr: "", isCarouselScrolling: !1, isAuthorTitleInsideScrolling: !1, curSongText: "", authorTitleInsideWait: 0, audioPlayerWidth: 0, audioPlayerHeight: 0, seekBarLeftRightSpacing: 15, category_arr: "", selectedCateg: "", categsAreListed: !1, thumbsHolder_Thumb: e('<div class="thumbsHolder_ThumbOFF" rel="0"><div class="padding">test</div></div>'), thumbsHolder_ThumbHeight: 0, thumbsHolder_Thumbs: "", search_val: "", constantDistance: 18, timerTopPos: 0, timerLeftPos: 0, bufferTopPos: 0, bufferLeftPos: 0, titleWidth: 0, authorTopPos: 0, authorLeftPos: 0, titleTopPos: 0, titleLeftPos: 0, imageTopPos: 0, imageLeftPos: 0, playTopPos: 0, playLeftPos: 0, previousTopPos: 0, previousLeftPos: 0, nextTopPos: 0, nextLeftPos: 0, volumeTopPos: 0, volumeLeftPos: 0, volumesliderTopPos: 0, volumesliderLeftPos: 0, bordersdivTopPos: 0, bordersdivLeftPos: 0, showhideplaylistTopPos: 0, showhideplaylistLeftPos: 0, rewindTopPos: 0, rewindLeftPos: 0, shuffleTopPos: 0, shuffleLeftPos: 0, downloadTopPos: 0, downloadLeftPos: 0, facebookTopPos: 0, facebookLeftPos: 0, twitterTopPos: 0, twitterLeftPos: 0, origParentFloat: "", origParentPaddingTop: "", origParentPaddingRight: "", origParentPaddingBottom: "", origParentPaddingLeft: "", windowWidth: 0, audioID: "", audioObj: ""};
            b.audioID = c.attr("id");
            a.showPlaylistBut || E.css({display: "none", width: 0, height: 0, padding: 0, margin: 0});
            b.timerTopPos = 10;
            b.timerLeftPos = b.constantDistance;
            w.css({color: a.timerColor, top: b.timerTopPos + "px", left: b.timerLeftPos + "px"});
            B.css({color: a.timerColor, top: b.timerTopPos + "px", right: b.timerLeftPos + "px"});
            d.width(a.playerWidth);
            a.origWidth = a.playerWidth;
            h.css({top: b.timerTopPos + w.height() + b.constantDistance + "px", left: b.timerLeftPos + "px"});
            b.imageTopPos = parseInt(h.css("top").substring(0, h.css("top").length - 2), 10);
            b.imageLeftPos = parseInt(h.css("left").substring(0, h.css("left").length - 2), 10);
            y.css({color: a.songTitleColor});
            u.css({color: a.songAuthorColor});
            b.titleWidth = a.playerWidth - b.timerLeftPos - h.width() - 2 * b.constantDistance;
            b.authorTopPos = b.imageTopPos + 2;
            b.authorLeftPos = b.imageLeftPos + h.width() + b.constantDistance;
            b.titleTopPos = parseInt(h.css("top").substring(0, h.css("top").length - 2), 10) + u.height() + 8;
            b.titleLeftPos = parseInt(h.css("left").substring(0, h.css("left").length - 2), 10) + h.width() + b.constantDistance;
            u.css({top: b.authorTopPos + "px", left: b.authorLeftPos + "px"});
            y.css({top: b.titleTopPos + "px", left: b.titleLeftPos + "px"});
            b.playTopPos = b.imageTopPos + h.height() - l.height();
            b.playLeftPos = b.imageLeftPos + h.width() + b.constantDistance + z.width() + parseInt(b.constantDistance / 2, 10);
            l.css({top: b.playTopPos + "px", left: b.playLeftPos + "px"});
            b.previousTopPos = b.playTopPos + parseInt((l.height() - z.height()) / 2, 10);
            b.previousLeftPos = b.imageLeftPos + h.width() + b.constantDistance;
            z.css({top: b.previousTopPos + "px", left: b.previousLeftPos + "px"});
            b.nextTopPos = b.previousTopPos;
            b.nextLeftPos = b.playLeftPos + l.width() + parseInt(b.constantDistance / 2, 10);
            m.css({top: b.nextTopPos + "px", left: b.nextLeftPos + "px"});
            b.volumeTopPos = b.nextTopPos + parseInt((m.height() - q.height()) / 2, 10);
            b.volumeLeftPos = b.nextLeftPos + m.width() + parseInt(1.5 * b.constantDistance, 10);
            q.css({top: b.volumeTopPos + "px", left: b.volumeLeftPos + "px"});
            b.volumesliderTopPos = b.volumeTopPos + parseInt((q.height() - A.height()) / 2, 10);
            b.volumesliderLeftPos = b.volumeLeftPos + q.width() + parseInt(b.constantDistance / 2, 10);
            A.css({top: b.volumesliderTopPos + "px", left: b.volumesliderLeftPos + "px"});
            b.bordersdivTopPos = b.imageTopPos + h.height() + b.constantDistance;
            b.bordersdivLeftPos = b.constantDistance;
            t.css({width: a.playerWidth - 2 * b.constantDistance + "px", "border-top-color": a.bordersDivColor, "border-bottom-color": a.bordersDivColor, top: b.bordersdivTopPos + "px", left: b.bordersdivLeftPos + "px"});
            b.audioPlayerHeight = b.bordersdivTopPos + t.height() + b.constantDistance;
            d.height(b.audioPlayerHeight);
            b.showhideplaylistTopPos = b.bordersdivTopPos + parseInt((t.height() - E.height()) / 2, 10);
            b.showhideplaylistLeftPos = b.constantDistance + 3;
            E.css({top: b.showhideplaylistTopPos + "px", right: b.showhideplaylistLeftPos + "px"});
            b.rewindTopPos = b.bordersdivTopPos + parseInt((t.height() - f.height()) / 2, 10);
            b.rewindLeftPos = b.constantDistance + 3;
            f.css({top: b.rewindTopPos + "px", left: b.rewindLeftPos + "px"});
            a.showRewindBut || (f.css({display: "none", width: 0, height: 0, padding: 0, margin: 0}), b.rewindLeftPos = 0);
            b.shuffleTopPos = b.bordersdivTopPos + parseInt((t.height() - g.height()) / 2, 10);
            b.shuffleLeftPos = b.rewindLeftPos + f.width() + b.constantDistance;
            g.css({top: b.shuffleTopPos + "px", left: b.shuffleLeftPos + "px"});
            a.shuffle && g.addClass("AudioShuffleON");
            a.showShuffleBut || (g.css({display: "none", width: 0, height: 0, padding: 0, margin: 0}), b.shuffleLeftPos = b.rewindLeftPos + f.width());
            b.downloadTopPos = b.bordersdivTopPos + parseInt((t.height() - n.height()) / 2, 10);
            b.downloadLeftPos = b.shuffleLeftPos + g.width() + b.constantDistance;
            n.css({top: b.downloadTopPos + "px", left: b.downloadLeftPos + "px"});
            a.showDownloadBut || (n.css({display: "none", width: 0, height: 0, padding: 0, margin: 0}), b.downloadLeftPos = b.shuffleLeftPos + g.width());
            b.facebookTopPos = b.bordersdivTopPos + parseInt((t.height() - p.height()) / 2, 10);
            b.facebookLeftPos = b.downloadLeftPos + n.width() + b.constantDistance;
            p.css({top: b.facebookTopPos + "px", left: b.facebookLeftPos + "px"});
            a.showFacebookBut ? (window.fbAsyncInit = function () {
                FB.init({appId: a.facebookAppID, version: "v2.0", status: !0, cookie: !0, xfbml: !0})
            }, function (a, b, c) {
                var d = a.getElementsByTagName(b)[0];
                a.getElementById(c) || (a = a.createElement(b), a.id = c, a.src = "//connect.facebook.com/en_US/sdk.js", d.parentNode.insertBefore(a, d))
            }(document, "script", "facebook-jssdk")) : (p.css({display: "none", width: 0, height: 0, padding: 0, margin: 0}), b.facebookLeftPos = b.downloadLeftPos + n.width());
            p.click(function () {
                var c = b.playlist_arr[b.origID].image, d = window.location.pathname.split("/");
                -1 == c.indexOf("http://") && -1 == c.indexOf("https://") && (-1 != d[d.length - 1].indexOf(".") && d.pop(), c = window.location.protocol + "//" + window.location.host + "/" + d.join("/") + "/" + b.playlist_arr[b.origID].image);
                FB.ui({method: "feed", name: a.facebookShareTitle, caption: b.playlist_arr[b.origID].title, description: a.facebookShareDescription, link: document.URL, picture: c}, function (a) {
                })
            });
            b.twitterTopPos = b.bordersdivTopPos + parseInt((t.height() - v.height()) / 2, 10);
            b.twitterLeftPos = b.facebookLeftPos + p.width() + b.constantDistance;
            v.css({top: b.twitterTopPos + "px", left: b.twitterLeftPos + "px"});
            a.showTwitterBut || (v.css({display: "none", width: 0, height: 0, padding: 0, margin: 0}), b.twitterLeftPos = b.facebookLeftPos + p.width());
            v.click(function () {
                window.open("https://twitter.com/intent/tweet?url=" + document.URL + "&text=" + b.playlist_arr[b.origID].title, "Twitter", "status = 1, left = 430, top = 270, height = 550, width = 420, resizable = 0")
            });
            var C = e(".thumbsHolderWrapper", d), T = e(".playlistPadding", d), M = e(".thumbsHolderVisibleWrapper", d), H = e(".thumbsHolder", d);
            b.audio2_html5_sliderVertical = e(".slider-vertical", d);
            var F = e(".selectedCategDiv", d), K = e(".innerSelectedCategDiv", d), N = e(".searchDiv", d), I = e(".search_term", d);
            a.showPlaylist || C.css({opacity: 0, visibility: "hidden"});
            a.showPlaylistOnInit || C.css({opacity: 0, visibility: "hidden", "margin-top": "-20px"});
            a.showCategories || F.css({visibility: "hidden", height: 0});
            F.css({"background-color": a.selectedCategBg, "background-position": "10px 50%", "margin-bottom": a.selectedCategMarginBottom + "px"});
            K.css({color: a.selectedCategOffColor, "background-position": a.playerWidth - 2 * a.playlistPadding - 20 + "px 50%"});
            a.showSearchArea || N.css({visibility: "hidden", height: 0});
            N.css({"background-color": a.searchAreaBg, "margin-top": a.selectedCategMarginBottom + "px"});
            I.val(a.searchInputText);
            I.css({width: parseInt((a.playerWidth - 2 * a.playlistPadding) / 2, 10) + "px", "background-color": a.searchInputBg, "border-color": a.searchInputBorderColor, color: a.searchInputTextColor});
            C.css({width: d.width() + 2 * a.playerPadding + "px", top: b.audioPlayerHeight + a.playlistTopPos + "px", left: "0px", background: a.playlistBgColor});
            M.width(d.width());
            b.playlist_arr = [];
            b.category_arr = [];
            var O = [];
            e(".xaudioplaylist", d).children().each(function () {
                currentElement = e(this);
                b.total_images++;
                b.playlist_arr[b.total_images - 1] = [];
                b.playlist_arr[b.total_images - 1].title = "";
                b.playlist_arr[b.total_images - 1].author = "";
                b.playlist_arr[b.total_images - 1].image = "";
                b.playlist_arr[b.total_images - 1].category = "";
                b.playlist_arr[b.total_images - 1].sources_mp3 = "";
                b.playlist_arr[b.total_images - 1].sources_ogg = "";
                null != currentElement.find(".xtitle").html() && (b.playlist_arr[b.total_images - 1].title = currentElement.find(".xtitle").html());
                null != currentElement.find(".xauthor").html() && (b.playlist_arr[b.total_images - 1].author = currentElement.find(".xauthor").html());
                null != currentElement.find(".ximage").html() && (b.playlist_arr[b.total_images - 1].image = currentElement.find(".ximage").html());
                if (null != currentElement.find(".xcategory").html()) {
                    b.playlist_arr[b.total_images - 1].category = currentElement.find(".xcategory").html() + ";";
                    O = b.playlist_arr[b.total_images - 1].category.split(";");
                    for (var a = 0; a < O.length; a++)-1 === b.category_arr.indexOf(O[a]) && "" != O[a] && b.category_arr.push(O[a])
                }
                null != currentElement.find(".xsources_mp3").html() && (b.playlist_arr[b.total_images - 1].sources_mp3 = currentElement.find(".xsources_mp3").html());
                null != currentElement.find(".xsources_ogg").html() && (b.playlist_arr[b.total_images - 1].sources_ogg = currentElement.find(".xsources_ogg").html())
            });
            b.numberOfCategories = b.category_arr.length;
            b.category_arr.sort();
            b.selectedCateg = a.firstCateg;
            "" == a.firstCateg && -1 === b.category_arr.indexOf(a.firstCateg) && (b.selectedCateg = b.category_arr[0]);
            K.html(b.selectedCateg);
            S(b, a, d, H, C, M, F, N, T, l, r, x, w, B, y, D, u, c, h);
            F.click(function () {
                b.search_val = "";
                I.val(a.searchInputText);
                X(b, a, d, H, C, M, F, K, N, T, l, r, x, w, B, y, D, u, c, h)
            });
            F.mouseover(function () {
                K.css({color: a.selectedCategOnColor})
            });
            F.mouseout(function () {
                K.css({color: a.selectedCategOffColor})
            });
            A.slider({value: a.initialVolume, step: .05, orientation: "horizontal", range: "min", max: 1, animate: !0, slide: function (a, c) {
                document.getElementById(b.audioID).volume = c.value
            }, stop: function (a, b) {
            }});
            document.getElementById(b.audioID).volume = a.initialVolume;
            A.css({background: a.volumeOffColor});
            e(".ui-slider-range", A).css({background: a.volumeOnColor});
            l.click(function () {
                var a = document.getElementById(b.audioID).paused;
                Q();
                0 == a ? (document.getElementById(b.audioID).pause(), l.removeClass("AudioPause")) : (document.getElementById(b.audioID).play(), l.addClass("AudioPause"))
            });
            f.click(function () {
                document.getElementById(b.audioID).currentTime = 0;
                Q();
                document.getElementById(b.audioID).play();
                l.addClass("AudioPause")
            });
            m.click(function () {
                b.categsAreListed || b.is_changeSrc && !b.is_very_first || (a.autoPlay = !0, b.thumbsHolder_Thumbs.css({background: a.playlistRecordBgOffColor, "border-bottom-color": a.playlistRecordBottomBorderOffColor, color: a.playlistRecordTextOffColor}), V(b, a, "next"), P(b, a, H, d, l, r, x, w, B, y, D, u, c, h))
            });
            z.click(function () {
                b.categsAreListed || b.is_changeSrc && !b.is_very_first || (a.autoPlay = !0, b.thumbsHolder_Thumbs.css({background: a.playlistRecordBgOffColor, "border-bottom-color": a.playlistRecordBottomBorderOffColor, color: a.playlistRecordTextOffColor}), V(b, a, "previous"), P(b, a, H, d, l, r, x, w, B, y, D, u, c, h))
            });
            E.click(function () {
                C.css({visibility: "visible"});
                0 > C.css("margin-top").substring(0, C.css("margin-top").length - 2) ? (aux_opacity = 1, aux_display = "block", aux_margin_top = "0px", C.css({display: aux_display}), b.selectedCateg_total_images > a.numberOfThumbsPerScreen && b.audio2_html5_sliderVertical.css({opacity: 1, display: "block"})) : (aux_opacity = 0, aux_display = "none", aux_margin_top = "-20px", b.selectedCateg_total_images > a.numberOfThumbsPerScreen && b.audio2_html5_sliderVertical.css({opacity: 0, display: "none"}));
                C.animate({opacity: aux_opacity, "margin-top": aux_margin_top}, 690, "easeOutQuad", function () {
                    C.css({display: aux_display})
                })
            });
            q.click(function () {
                document.getElementById(b.audioID).muted ? (document.getElementById(b.audioID).muted = !1, q.removeClass("VolumeButtonMuted")) : (document.getElementById(b.audioID).muted = !0, q.addClass("VolumeButtonMuted"))
            });
            g.click(function () {
                a.shuffle ? (g.removeClass("AudioShuffleON"), a.shuffle = !1) : (g.addClass("AudioShuffleON"), a.shuffle = !0)
            });
            n.click(function () {
                window.open(a.pathToDownloadFile + "download.php?the_file=" + b.playlist_arr[b.origID].sources_mp3)
            });
            H.swipe({swipeStatus: function (c, d, e, f, g, h) {
                "up" != e && "down" != e || 0 == f || (currentScrollVal = b.audio2_html5_sliderVertical.slider("value"), currentScrollVal = "up" == e ? currentScrollVal - 1.5 : currentScrollVal + 1.5, b.audio2_html5_sliderVertical.slider("value", currentScrollVal), J(currentScrollVal, b, a, H))
            }, threshold: 100, maxTimeThreshold: 500, fingers: "all"});
            I.on("click", function () {
                e(this).val("")
            });
            I.on("input", function () {
                b.search_val = I.val().toLowerCase();
                S(b, a, d, H, C, M, F, N, T, l, r, x, w, B, y, D, u, c, h)
            });
            document.getElementById(b.audioID).addEventListener("ended", function () {
                a.loop && m.click()
            });
            a.googleTrakingOn && ga("create", a.googleTrakingCode, "auto");
            P(b, a, H, d, l, r, x, w, B, y, D, u, c, h);
            b.timeupdateInterval = setInterval(function () {
                W(b, a, d, r, x, w, B, l, c, y, D, u)
            }, 300);
            document.getElementById(b.audioID).addEventListener("durationchange", function () {
                b.is_changeSrc && (b.totalTime = document.getElementById(b.audioID).duration)
            });
            if (-1 != k.indexOf("ipad") || -1 != k.indexOf("iphone") || -1 != k.indexOf("ipod") || -1 != k.indexOf("webos"))b.totalTime = 0, document.getElementById(b.audioID).addEventListener("canplaythrough", function () {
                b.totalTime != document.getElementById(b.audioID).duration && (a.isSliderInitialized && (r.slider("destroy"), a.isSliderInitialized = !1), a.isProgressInitialized && (x.progressbar("destroy"), a.isProgressInitialized = !1), b.totalTime = document.getElementById(b.audioID).duration, R(b, a, d, r, x, w, B, l, c), a.isProgressInitialized && x.progressbar({value: a.playerWidth}))
            });
            var L = function () {
                "" == b.origParentFloat && (b.origParentFloat = d.parent().css("float"), b.origParentPaddingTop = d.parent().css("padding-top"), b.origParentPaddingRight = d.parent().css("padding-right"), b.origParentPaddingBottom = d.parent().css("padding-bottom"), b.origParentPaddingLeft = d.parent().css("padding-left"));
                a.playerWidth != a.origWidth || a.playerWidth > e(window).width() ? d.parent().css({"float": "none", "padding-top": 0, "padding-right": 0, "padding-bottom": 0, "padding-left": 0}) : d.parent().css({"float": b.origParentFloat, "padding-top": b.origParentPaddingTop, "padding-right": b.origParentPaddingRight, "padding-bottom": b.origParentPaddingBottom, "padding-left": b.origParentPaddingLeft});
                var c = d.parent().width();
                385 > a.playerWidth ? A.css({display: "none"}) : A.css({display: "block"});
                270 > a.playerWidth ? q.css({display: "none"}) : q.css({display: "block"});
                240 > a.playerWidth ? m.css({display: "none"}) : m.css({display: "block"});
                d.width() != c && (a.playerWidth = a.origWidth > c ? c : a.origWidth, 385 > a.playerWidth ? A.css({display: "none"}) : A.css({display: "block"}), 270 > a.playerWidth ? q.css({display: "none"}) : q.css({display: "block"}), 240 > a.playerWidth ? m.css({display: "none"}) : m.css({display: "block"}), d.width() != a.playerWidth && (d.width(a.playerWidth), c = a.playerWidth - 2 * b.timerLeftPos - 2 * w.width() - 2 * b.seekBarLeftRightSpacing, x.width(c), r.width(c), t.css({width: a.playerWidth - 2 * b.constantDistance + "px"}), b.titleWidth = a.playerWidth - b.timerLeftPos - h.width() - 2 * b.constantDistance, y.width(b.titleWidth), u.width(b.titleWidth), C.width(d.width() + 2 * a.playerPadding), M.width(d.width()), F.width(a.playerWidth - 2 * a.playlistPadding), K.css({"background-position": a.playerWidth - 2 * a.playlistPadding - 20 + "px 50%"}), b.selectedCateg_total_images > a.numberOfThumbsPerScreen && a.showPlaylist ? (b.audio2_html5_sliderVertical.css({left: d.width() + 2 * a.playerPadding - b.audio2_html5_sliderVertical.width() - a.playlistPadding + "px"}), e(".thumbsHolder_ThumbOFF", d).css({width: d.width() + 2 * a.playerPadding - b.audio2_html5_sliderVertical.width() - 2 * a.playlistPadding - 3 + "px"})) : e(".thumbsHolder_ThumbOFF", d).css({width: d.width() + 2 * a.playerPadding - 2 * a.playlistPadding + "px"}), I.css({width: parseInt((a.playerWidth - 2 * a.playlistPadding) / 2, 10) + "px"})), a.playerWidth < e(window).width() && d.parent().css({"float": b.origParentFloat, "padding-top": b.origParentPaddingTop, "padding-right": b.origParentPaddingRight, "padding-bottom": b.origParentPaddingBottom, "padding-left": b.origParentPaddingLeft}))
            }, U = !1;
            e(window).resize(function () {
                doResizeNow = !0;
                -1 != G && 9 == G && 0 == b.windowWidth && (doResizeNow = !1);
                b.windowWidth == e(window).width() ? (doResizeNow = !1, a.windowCurOrientation != window.orientation && -1 != navigator.userAgent.indexOf("Android") && (a.windowCurOrientation = window.orientation, doResizeNow = !0)) : b.windowWidth = e(window).width();
                a.responsive && doResizeNow && (!1 !== U && clearTimeout(U), U = setTimeout(function () {
                    L()
                }, 300))
            });
            a.responsive && L()
        })
    };
    e.fn.audio2_html5.defaults = {playerWidth: 690, skin: "whiteControllers", initialVolume: .5, autoPlay: !1, loop: !0, shuffle: !1, playerPadding: 0, playerBg: "#000000", bufferEmptyColor: "#929292", bufferFullColor: "#454545", seekbarColor: "#ffffff", volumeOffColor: "#454545", volumeOnColor: "#ffffff", timerColor: "#ffffff", songTitleColor: "#a6a6a6", songAuthorColor: "#ffffff", bordersDivColor: "#333333", showRewindBut: !0, showShuffleBut: !0, showDownloadBut: !0, showFacebookBut: !0, facebookAppID: "851072315000860", facebookShareTitle: "HTML5 Audio Player PRO", facebookShareDescription: "A top-notch responsive HTML5 Audio Player compatible with all major browsers and mobile devices.", showTwitterBut: !0, showAuthor: !0, showTitle: !0, showPlaylistBut: !0, showPlaylist: !0, showPlaylistOnInit: !0, playlistTopPos: 2, playlistBgColor: "#000000", playlistRecordBgOffColor: "#000000", playlistRecordBgOnColor: "#333333", playlistRecordBottomBorderOffColor: "#333333", playlistRecordBottomBorderOnColor: "#4d4d4d", playlistRecordTextOffColor: "#777777", playlistRecordTextOnColor: "#FFFFFF", categoryRecordBgOffColor: "#191919", categoryRecordBgOnColor: "#252525", categoryRecordBottomBorderOffColor: "#2f2f2f", categoryRecordBottomBorderOnColor: "#2f2f2f", categoryRecordTextOffColor: "#4c4c4c", categoryRecordTextOnColor: "#00b4f9", numberOfThumbsPerScreen: 7, playlistPadding: 18, showCategories: !0, firstCateg: "", selectedCategBg: "#333333", selectedCategOffColor: "#FFFFFF", selectedCategOnColor: "#00b4f9", selectedCategMarginBottom: 12, showSearchArea: !0, searchAreaBg: "#333333", searchInputText: "Tìm kiếm...", searchInputBg: "#ffffff", searchInputBorderColor: "#333333", searchInputTextColor: "#333333", googleTrakingOn: !1, googleTrakingCode: "", responsive: !1, origWidth: 0, pathToDownloadFile: "", showPlaylistNumber: !0, isSliderInitialized: !1, isProgressInitialized: !1, isPlaylistSliderInitialized: !1}
})(jQuery);