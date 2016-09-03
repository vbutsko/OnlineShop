/**
 * Created by wladek on 01.09.16.
 */
(function() {
    $(".add_shop").on('click', function () {
        var phone = $(this).parent('.mobile_shop');

        var amount = phone.find("[name=amount]").val();
        var productId = phone.find("[name=productId]").val();
        var name = phone.find("[name=name]").val();

        $.ajax({
            type: "POST",
            url: "/web/cart",
            data: "amount=" + amount + "&productId=" + productId + "&name=" + name,
            success: function (response) {
                var message = response.result;
                if (response.status == "SUCCESS") {
                    message = "<p style=\"color:green\">" + message + "</p>";
                    updateTotalBar();
                }
                else
                    message = "<p style=\"color:red\">" + message + "</p>";
                phone.find("[name=info]").html(message);

            },
            error: function (e) {
                alert('Error: ' + e);
            }
        });
    });
})();

window.onload = updateTotalBar;
function updateTotalBar() {
    $.ajax({
        type: "POST",
        url: "/web/total/update",
        success: function (response) {
            $('#headerTotal').html(response);
        },
        error: function (e) {
            alert('Error: ' + e);
        }
    });
}