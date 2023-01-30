function createTodoList() {
    var url = "/todo/add";
    var name = "To Do List 추가하기";

    var option = "width = 550, height = 250, top = 100, left = 200, location = no"

    window.open(url, name, option);
}

function addTodoList() {

    var todoList = {
        category : document.getElementById("category").value,
        content : document.getElementById("content").value,
    }

    $.ajax({
        url:"/todo/add",
        type:"POST",
        contentType: 'application/json',
        data: JSON.stringify(todoList),
        success: function(result) {
            if (result) {
                window.close();
                opener.location.reload();
            } else {
                alert("다시 한번 시도해주세요.");
            }
        }
    });

}

function completeTodolist(idx) {
    $.ajax({
        url:"/todo/patch/"+idx,
        type:"PATCH",
        success: function(result) {
            if (result) {
                window.location.href = "/"
            } else {
                alert("다시 한번 시도해주세요.");
            }
        }
    });
}

function notCompleteTodolist(idx) {
    $.ajax({
        url:"/todo/patch/"+idx,
        type:"PATCH",
        success: function(result) {
            if (result) {
                window.location.href = "/"
            } else {
                alert("다시 한번 시도해주세요.");
            }
        }
    });
}

function deleteTodolist(idx) {
    $.ajax({
        url:"/todo/del/"+idx,
        type:"DELETE",
        success: function(result) {
            if (result) {
                window.location.href = "/"
                alert("삭제되었습니다.");
            } else {
                alert("다시 한번 시도해주세요.");
            }
        }
    });
}

function searchTodolists() {
    var searchDatetime = document.getElementById("todoDatetime").value;

    
    if (searchDatetime == "") {
        alert("검색하실 날짜를 입력해주세요");       
    } else {
        window.location.href = "/todo/search/"+searchDatetime;
    }

}