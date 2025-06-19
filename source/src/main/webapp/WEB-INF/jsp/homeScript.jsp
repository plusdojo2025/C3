<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
    let changeTargetId = '';
    let changeParentId = '';
    const changeParentArray = ['sun', 'mon', 'tue', 'wed', 'thu', 'fri', 'sat', 'etc'];
    const drugChangeArray = [
        'item-10',
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
        'item-10-top', 'item-10-end',
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
        }
        if (changeTargetId && changeParentId) {
            const nowParentId = $(document.elementFromPoint(e.clientX, e.clientY)).attr('id');
            if (changeParentId !== nowParentId && changeParentArray.includes(nowParentId)) {
                const changeElement = $('#' + changeTargetId);
                changeParentId = nowParentId;
                $('#' + changeParentId).append(changeElement);
                $('#home-form input[name="' + changeElement.attr("id") + '[2]"').val(changeParentId);
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
        $('#item-10').css('top', $('#home-form input[name^="item-10[0]').val() + 'px');
        $('#item-10').css('height', $('#home-form input[name^="item-10[1]').val() + 'px');
    }); 
</script>