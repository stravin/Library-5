var listAuthorIds;
var listAllAuthors;

var adjustAuthorLists = function () {
    var bookAuthors = listAuthorIds.options;
    var allAuthors = listAllAuthors.options;

    for (var i = bookAuthors.length-1; i >= 0; i--) {
        for (var j = allAuthors.length-1; j >= 0; j--) {
            if (bookAuthors[i].value == allAuthors[j].value) {
                allAuthors[j].remove();
            }
        }
    }
};

var moveSelectedItems = function (listFrom, listInto) {

    var selectedOptions = listFrom.selectedOptions;

    for (var i = selectedOptions.length-1; i >=0 ; i--) {
        var opt = selectedOptions[i];
        listInto.appendChild(opt);
    }
};

window.onload = function () {

    listAuthorIds = document.getElementById("authorids");
    listAllAuthors = document.getElementById("allauthors");

    adjustAuthorLists();

    var buttonDeleteAuthors = document.getElementById("buttonDeleteAuthors");
    buttonDeleteAuthors.addEventListener("click", function () {
            moveSelectedItems(listAuthorIds, listAllAuthors);
        }
    );

    var buttonAddAuthors = document.getElementById("buttonAddAuthors");
    buttonAddAuthors.addEventListener("click", function () {
            moveSelectedItems(listAllAuthors, listAuthorIds);
        }
    );
};
