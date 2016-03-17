/**
 * @license Copyright (c) 2003-2014, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function (config) {
    config.minimumChangeMilliseconds = 100;
    config.toolbar = 'bdFull';

    config.toolbar_bdFull =
        [
            ['Source'],
            ['Image'],
            ['RemoveFormat'],
            ['TextColor', 'Font', 'FontSize'],
            ['Smiley'],
            ['Undo', 'Remo'],
            ['Bold', 'Italic', 'Underline', 'Strike' ],
            ['Link', 'Unlink'],
            ['Outdent', 'Indent'],
            ['JustifyLeft', 'JustifyCenter', 'JustifyRight']
        ];

    config.forcePasteAsPlainText = true;
    config.enterMode = CKEDITOR.ENTER_BR;

};