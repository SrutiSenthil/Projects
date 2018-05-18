app.controller("FormGeneratorController", function($scope,$http) {
	$scope.form={};
    $scope.form.formLabel=null;
    $scope.form.formLabelName=null;
    $scope.form.formRadio=null;
    $scope.form.formRadioItems=null;
    $scope.form.formCheck=null;
    $scope.form.formCheckItems=null;
    $scope.form.formDropdown=null;
    $scope.form.formDropdownItems=null;
    $scope.form.formText=null;
    $scope.form.formTextRow=null;
    $scope.form.formTextColumn=null;
    $scope.form.formButton=null;
    $scope.form.message = null;
    $scope.form.position=null;
       
    $scope.form.formWidthSize=null;
    $scope.form.formPaddingSize1=null;
    $scope.form.formPaddingSize2=null;
    $scope.form.formMarginSize1=null;
    $scope.form.formMarginSize2=null;
    $scope.form.formRadiusSize=null;
    $scope.form.formButtonWidth=null;
    $scope.form.formButtonColor=null;
    $scope.form.formButtonFontColor=null;
    $scope.form.formButtonPaddingSize1=null;
    $scope.form.formButtonPaddingSize2=null;
    $scope.form.formButtonMarginSize1=null;
    $scope.form.formButtonMarginSize2=null;
    $scope.form.formButtonRadiusSize=null;
    $scope.form.formButtonHoverColor=null;
    
    
    $scope.dformfunc = function(){
    	var data = JSON.stringify($scope.form);
        $http.post(URI+"Form/dform",data).then(
                     function(response){
                            alert(response.data.message);
                            $scope.form.message = response.data.message;
                     },function(response){
                            alert(response.data.message);
                            $scope.form.message = response.data.message;
                     });
    };
    
});


app.controller("ImageGeneratorController", function($scope,$http) {
	
	$scope.image={};
    $scope.image.imgSource=null;
    $scope.image.imgDescription=null;
    $scope.image.imgWidth=null;
    $scope.image.imgWidthType="%";
    $scope.image.imgHeight=null;
    $scope.image.imgHeightType="%";
    $scope.image.imgFloat=null;
    $scope.image.position=null;
    
    $scope.image.borderRadius = null;
    $scope.image.filterType = null;
    $scope.image.blurValue = null;
    $scope.image.brightnessValue = null;
    $scope.image.contrastValue = null;
    $scope.image.grayscaleValue = null;
    $scope.image.huerotateValue = null;
    $scope.image.invertValue = null;
    $scope.image.opacityValue = null;
    $scope.image.saturateValue = null;
    $scope.image.sepiaValue = null;
    $scope.image.shadowValue1 = null;
    $scope.image.shadowValue2 = null;
    $scope.image.shadowValue3 = null;
    $scope.image.shadowColor = null;
    $scope.image.polaroid=null;
    $scope.image.flip=null;
    $scope.image.message = null;
	
    
    $scope.dimagefunc = function(){
    	var data = JSON.stringify($scope.image);
        $http.post(URI+"Image/dimage",data).then(
                     function(response){
                            alert(response.data.message);
                            $scope.image.message = response.data.message;
                     },function(response){
                            alert(response.data.message);
                            $scope.image.message = response.data.message;
                     });
    };
});

app.controller("ListGeneratorContoller", function($scope,$http) {
	$scope.list={}
    $scope.list.listType=null;
    $scope.list.descItems=null;
    $scope.list.unorderListType=null;
    $scope.list.unorderListItems=null;
    $scope.list.orderedListType=null;
    $scope.list.orderedListItems=null;
    $scope.list.position=null;
    
    $scope.list.listMarker=null;
    $scope.list.listDefault=null;
    $scope.list.message = null;
    
    $scope.dlistfunc = function(){
    	var data = JSON.stringify($scope.list);
        $http.post(URI+"List/dlist",data).then(
                     function(response){
                            alert(response.data.message);
                            $scope.list.message = response.data.message;
                     },function(response){
                            alert(response.data.message);
                            $scope.list.message = response.data.message;
                     });
    };
});

app.controller("TableGeneratorController", function($scope,$http) {
	$scope.table={};
	$scope.table.noOfRows=null;
	$scope.table.noOfColumns = null;
	$scope.table.position=null;
	
	$scope.table.borderWidth=null;
	$scope.table.borderStyle=null;
	$scope.table.borderColor=null;
	$scope.table.borderCollapse=null;
	$scope.table.tableWidth=null;
	$scope.table.tableWidthUnit=null;
	$scope.table.tableHeight=null;
	$scope.table.tableHeightUnit=null;
	$scope.table.horizontalAlign=null;
	$scope.table.verticalAlign=null;
	$scope.table.tablePadding=null;
	$scope.table.tablePaddingUnit=null;
	$scope.table.horizontalDividers=null;
	$scope.table.horizontalborderWidth=null;
	$scope.table.horizontalborderStyle=null;
	$scope.table.horizontalborderColor=null;
	$scope.table.hovertable=null;
	$scope.table.hovertableColor=null;
	$scope.table.stripedtable=null;
	$scope.table.stripedtableColor=null;
	$scope.table.stripedtableValue=null;
	$scope.table.tableBackgroundColor=null;
	$scope.table.tableTextColor=null;
	$scope.table.responsivetable=null;
	$scope.table.message=null;
	
	$scope.dtablefunc = function(){
    	var data = JSON.stringify($scope.table);
        $http.post(URI+"Table/dtable",data).then(
                     function(response){
                            alert(response.data.message);
                            $scope.table.message = response.data.message;
                     },function(response){
                            alert(response.data.message);
                            $scope.table.message = response.data.message;
                     });
    };
});

app.controller("ContentGeneratorController", function($scope,$http) {
	$scope.content={};
	$scope.content.description=null;
	$scope.content.fontFamily=null;
	$scope.content.fontSize=null;
	$scope.content.fontStyle=null;
	$scope.content.fontWeight=null;
	$scope.content.fontVarient=null;
	$scope.content.fontColor=null;
	$scope.content.message=null;
	$scope.content.position=null;
	
	$scope.dcontentfunc = function(){
		if($scope.content.fontSize!=null){
            $scope.content.fontSize =  $scope.content.fontSize.toString();
		}
		if( $scope.content.fontWeight!=null){
			 $scope.content.fontWeight =  $scope.content.fontWeight.toString();
		}
     
    	var data = JSON.stringify($scope.content);
        $http.post(URI+"Content/dcontent",data).then(
                     function(response){
                            alert(response.data.message);
                            $scope.content.message = response.data.message;
                     },function(response){
                            alert(response.data.message);
                            $scope.content.message = response.data.message;
                     });
    };
});


