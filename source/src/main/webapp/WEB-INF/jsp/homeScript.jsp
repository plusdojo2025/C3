<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
    let changeTargetId = '';
    let changeParentId = '';
    const changeParentArray = ['sun', 'mon', 'tue', 'wed', 'thu', 'fri', 'sat', 'etc1', 'etc2', 'etc3'];
    const drugChangeArray = [
    	<c:forEach var="e" items="${dWork}" >
			"item-<c:out value='${e.u_id}'/>", 
		</c:forEach>
		<c:forEach var="e" items="${dWalk}" >
			"item-<c:out value='${e.u_id}'/>", 
		</c:forEach>
    ];
    $(".box").on("mousedown", function (e) {
        const isChanging = (drugChangeArray.includes(this.id));
        if (isChanging) {
            changeTargetId = $(this).attr('id');
            changeParentId = $(this).parent().attr('id');
            $('#weekly-list').css('cursor', 'move');
            e.preventDefault();
        } else {
            currentId = '';
        }
    });

    let startY, startBox, startTop, startIsTop, startHeight;
    const drugBarUnit = (10 * 2);
    const drugResizeArray = [
    	<c:forEach var="e" items="${dWork}" >
    		"item-<c:out value='${e.u_id}'/>-top", "item-<c:out value='${e.u_id}'/>-end",
		</c:forEach>
		<c:forEach var="e" items="${dWalk}" >
			"item-<c:out value='${e.u_id}'/>-top", "item-<c:out value='${e.u_id}'/>-end",
		</c:forEach>
    ];
    $(".drug-bar").on("mousedown", function (e) {
        const isResizing = (drugResizeArray.includes(this.id));
        if (isResizing) {
            startY = e.clientY;
            startIsTop = $(this).hasClass('drug-bar-top');
            startBox = $(this).parent();
            startTop = parseInt(startBox.css('top'));
            startHeight = startBox.height();
            e.preventDefault();
        } else {
            startBox = undefined;
        }
    });

    $(document).on("mousemove", function (e) {
        if (e.clientY == startY)
            return;
        if (startBox != undefined) {
            const parentHeight = startBox.parent().height();
            const diffHeight = (e.clientY - startY);
            if (startIsTop) {
                const newTop = startTop + diffHeight;
                if (newTop < 0) {
                    startBox.css("top", '0px');
                    startBox.css("height", (startTop + startHeight) + 'px');
                } else {
                    const maxTop = (startTop + startHeight - drugBarUnit);
                    if (maxTop < newTop) {
                        startBox.css("top", maxTop + 'px');
                    } else {
                        startBox.css("top", newTop + 'px');
                    }
                    const newHeight = startHeight - diffHeight;
                    if (drugBarUnit < newHeight) {
                        const limitHeight = parentHeight;
                        if (limitHeight < newHeight) {
                            startBox.css("height", limitHeight + 'px');
                        } else {
                            startBox.css("height", newHeight + 'px');
                        }
                    } else {
                        startBox.css("height", drugBarUnit + 'px');
                    }
                    
                }
            } else {
                const newHeight = startHeight + diffHeight;
                const limitHeight = (parentHeight - startTop);
                if (limitHeight < newHeight) {
                    startBox.css("height", limitHeight + 'px');
                } else {
                    if (newHeight < drugBarUnit) {
                        startBox.css("height", drugBarUnit + 'px');
                    } else {
                        startBox.css("height", newHeight + 'px');
                    }
                }
            }
            $('#home-form input[name="' + startBox.attr("id") + '[0]"').val(parseInt(startBox.css("top")));
            $('#home-form input[name="' + startBox.attr("id") + '[1]"').val(parseInt(startBox.css("height")));
            localStorage.setItem(startBox.attr("id") + '[0]', parseInt(startBox.css("top")));
            localStorage.setItem(startBox.attr("id") + '[1]', parseInt(startBox.css("height")));
        }
        if (changeTargetId && changeParentId) {
            const nowParentId = $(document.elementFromPoint(e.clientX, e.clientY)).attr('id');
            if (changeParentId !== nowParentId && changeParentArray.includes(nowParentId)) {
                const changeElement = $('#' + changeTargetId);
                changeParentId = nowParentId;
                $('#' + changeParentId).append(changeElement);
                $('#home-form input[name="' + changeElement.attr("id") + '[2]"').val(changeParentId);
                localStorage.setItem(changeElement.attr("id") + '[2]', changeParentId);
            }
        }
    });

    $(document).on("mouseup", function () {
        startBox = undefined;
        changeTargetId = '';
        changeParentId = '';
        $('#weekly-list').css('cursor', 'default');
    });
    $(window).on('load', function () {
    	let localStorageItem = ""
    	<c:forEach var="e" items="${dWork}" >
    		
        	localStorageItem = localStorage.getItem("item-<c:out value='${e.u_id}'/>[0]");
        	if(localStorageItem){
        		$('#home-form input[name^="item-'+"<c:out value='${e.u_id}'/>"+'[0]').val(localStorageItem);
        		//$("#item-<c:out value='${e.u_id}'/>").css('top', localStorageItem + 'px');
        	}
        	localStorageItem = localStorage.getItem("item-<c:out value='${e.u_id}'/>[1]");
        	if(localStorageItem){
        		$('#home-form input[name^="item-'+"<c:out value='${e.u_id}'/>"+'[1]').val(localStorageItem);
        		//$("#item-<c:out value='${e.u_id}'/>").css('height', localStorageItem + 'px');
        	}
        	localStorageItem = localStorage.getItem("item-<c:out value='${e.u_id}'/>[2]");
        	if(localStorageItem){
                if (changeParentArray.includes(localStorageItem)) {
                    const changeElement = $("#item-<c:out value='${e.u_id}'/>");
                    $('#' + localStorageItem).append(changeElement);
                    $('#home-form input[name="' + changeElement.attr("id") + '[2]"').val(localStorageItem);
                }
        	}
        	$("#item-<c:out value='${e.u_id}'/>").css('top', $('#home-form input[name^="item-'+"<c:out value='${e.u_id}'/>"+'[0]').val() + 'px');
        	$("#item-<c:out value='${e.u_id}'/>").css('height', $('#home-form input[name^="item-'+"<c:out value='${e.u_id}'/>"+'[1]').val() + 'px');
		</c:forEach>
		<c:forEach var="e" items="${dWalk}" >
			
    		localStorageItem = localStorage.getItem("item-<c:out value='${e.u_id}'/>[0]");
    		if(localStorageItem){
    			$('#home-form input[name^="item-'+"<c:out value='${e.u_id}'/>"+'[0]').val(localStorageItem);
        		//$("#item-<c:out value='${e.u_id}'/>").css('top', localStorageItem + 'px');
        	}
        	localStorageItem = localStorage.getItem("item-<c:out value='${e.u_id}'/>[1]");
        	if(localStorageItem){
        		$('#home-form input[name^="item-'+"<c:out value='${e.u_id}'/>"+'[1]').val(localStorageItem);
        		//$("#item-<c:out value='${e.u_id}'/>").css('height', localStorageItem + 'px');
        	}
        	localStorageItem = localStorage.getItem("item-<c:out value='${e.u_id}'/>[2]");
        	if(localStorageItem){
                if (changeParentArray.includes(localStorageItem)) {
                    const changeElement = $("#item-<c:out value='${e.u_id}'/>");
                    $('#' + localStorageItem).append(changeElement);
                    $('#home-form input[name="' + changeElement.attr("id") + '[2]"').val(localStorageItem);
                }
        	}
        	$("#item-<c:out value='${e.u_id}'/>").css('top', $('#home-form input[name^="item-'+"<c:out value='${e.u_id}'/>"+'[0]').val() + 'px');
    		$("#item-<c:out value='${e.u_id}'/>").css('height', $('#home-form input[name^="item-'+"<c:out value='${e.u_id}'/>"+'[1]').val() + 'px');
    	</c:forEach>
    }); 
    
    function getCurrentWeekDates() {
        const today = new Date();
        const dayOfWeek = today.getDay(); // 0: 日曜, 1: 月曜, ..., 6: 土曜

        // 日曜日を取得
        const sunday = new Date(today);
        sunday.setDate(today.getDate() - dayOfWeek);

        // 日曜〜土曜までの配列を作る
        const weekDates = [];
        for (let i = 0; i < 7; i++) {
            const d = new Date(sunday);
            d.setDate(sunday.getDate() + i);
            weekDates.push(d);
        }

        return weekDates;
    }
    
    document.getElementById("clear-storage").onclick = function() {
        if (confirm("位置をリセットしてよろしいですか？")){
        	localStorage.clear();
        	alert("位置をリセットしました");
        }
        else{
        	alert("キャンセルしました");
        }
    	
        
      };
      document.getElementById("decide").onclick = function() {
    	  alert("確定しました");
      }
    /*window.addEventListener('DOMContentLoaded', function() {
    	// 1. input要素から値を取得
    	 let input = document.getElementById('boxHeight');
    	 let val = input.value;
    	 let num = Number(val);
    	 
    	// 2. 四捨五入して10で割り、4px倍
    	 let px = Math.round(num / 10) * 4;
    	
    	// 3. px値をvalueに再セット
    	 input.value = px + 'px';
    });*/
</script>