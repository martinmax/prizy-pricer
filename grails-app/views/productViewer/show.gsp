<!DOCTYPE html>
<html lang="en">
    <g:render template="/layouts/head"/>
    <r:require modules="jquery,grailsEvents"/>
    <r:layoutResources/>
<body>
<r:layoutResources/>
<g:render template="/layouts/navigation"/>
<script type="text/javascript">
    // Eventing, when a new survey is created, it makes a AJAX call and it refreshes the data in the productViewer in the background
    try {
        var grailsEvents = new grails.Events("${createLink(uri:'')}", {transport: "sse"});
        grailsEvents.on('newSurveyCreated', function (data) {
            if(data == ${product.barCode}) {
                $.get(window.location.href).success(function (data) {
                    $("#highestPrice").text($(data).find("#highestPrice").text())
                    $("#lowestPrice").text($(data).find("#lowestPrice").text())
                    $("#averagePrice").text($(data).find("#averagePrice").text())
                    $("#idealPrice").text($(data).find("#idealPrice").text())
                    $("#idealPriceError").text($(data).find("#idealPriceError").text())
                    $("#pricesCollected").text($(data).find("#pricesCollected").text())
                }).error(function (error) {
                    console.log("Error while reloading content" + error);
                })
            }
        });
    } catch (error) {
        console.log("ERROR: " + error.toString());
    }
</script>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-lg-12 text-center">
            <div style="padding-top: 100px" class="text-justify">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Bar code:</label>
                        <div class="col-sm-10" style="padding-top: 7px">
                            <label id="barCode"> ${product?.barCode}</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Decription:</label>
                        <div class="col-sm-10" style="padding-top: 7px">
                            <label id="description">${product?.description}</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Highest price:</label>
                        <div class="col-sm-10" style="padding-top: 7px">
                            <label id="highestPrice">${highestPrice}</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Lowest price:</label>
                        <div class="col-sm-10" style="padding-top: 7px">
                            <label id="lowestPrice">${lowestPrice}</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Average price:</label>
                        <div class="col-sm-10" style="padding-top: 7px">
                            <label id="averagePrice">${averagePrice}</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Ideal price:</label>
                        <div class="col-sm-10" style="padding-top: 7px">
                                <label id="idealPrice">${idealPrice}</label>
                                <label id="idealPriceError">${idealPriceError}</label>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2">Number of prices collected:</label>
                        <div class="col-sm-10" style="padding-top: 7px">
                            <label id="pricesCollected">${pricesCollected}</label>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.container -->
</body>
</html>