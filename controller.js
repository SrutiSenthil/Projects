application.controller("FormGeneratorController", function($scope,$http,$sce) {
       $scope.form={};
       $scope.cssform={};
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
       
       $scope.cssform.formWidthSize=null;
       $scope.cssform.formPaddingSize1=null;
       $scope.cssform.formPaddingSize2=null;
       $scope.cssform.formMarginSize1=null;
       $scope.cssform.formMarginSize2=null;
       $scope.cssform.formRadiusSize=null;
       $scope.cssform.formButtonWidth=null;
       $scope.cssform.formButtonColor=null;
       $scope.cssform.formButtonFontColor=null;
       $scope.cssform.formButtonPaddingSize1=null;
       $scope.cssform.formButtonPaddingSize2=null;
       $scope.cssform.formButtonMarginSize1=null;
       $scope.cssform.formButtonMarginSize2=null;
       $scope.cssform.formButtonRadiusSize=null;
       $scope.cssform.formButtonHoverColor=null;
       $scope.cssform.message= null;
       
       $scope.nameClickFunction = function()
       {
              var data = JSON.stringify($scope.form);
              $http.post(URI+"Form/form",data).then(
                           function(response){
                                  alert(response.data.message);
                                  $scope.form.message = response.data.message;
                           },function(response){
                                  alert(response.data.message);
                                  $scope.form.message = response.data.message;
                           });
       };
       
       
       $scope.cssnameClickFunction = function()
       {
              var cssdata = JSON.stringify($scope.cssform);
              $http.post(URI+"Form/cssform",cssdata).then(
                           function(response){
                                  alert(response.data.message);
                                  $scope.form.message = response.data.message;
                           },function(response){
                                  alert(response.data.message);
                                  $scope.form.message = response.data.message;
                           });
       };
       
       $scope.myfunc= function()
       { 
          $http.get(URI+"Form/Form.html").then(
                   
                   function(response){
                       var data1=response.data;
                       var len=data1.indexOf("head");
                       var str1 = data1.substring(0,len+5);
                       $http.get(URI+"Form/FormCSS.css").then(
                               function(response){
                                    var data2=response.data;
                                    var len1=data2.indexOf("}");
                                   var str2 = str1+"<style> #prev "+data2.substring(0,len1+1);
                                   while(len1>0){
                                   var sbstr1 = data2.substring(len1+1);
                                   var len1 = sbstr1.indexOf("}");
                                   str2 = str2+"#prev "+sbstr1.substring(0,len1+1);
                                   data2 = sbstr1;
                                   }
                                   var indexf = str2.lastIndexOf("#prev ");
                                   var str3 = str2.substring(0,indexf);
                                   str3 = str3+"</style>"+data1.substring(len+5);
                                   var len2 = str3.indexOf("<body>");
                                   var str4 = str3.substring(0,len2+6)+" <div id=\"prev\" >";
                                   var len3 = str3.indexOf("</body>");
                                   str4 = str4+str3.substring(len2+6,len3)+"</div></body></html>";
                                   
                                   $scope.formValue =  $sce.trustAsHtml(str4);
                          
                               },function(response){
                                     $scope.formcssValue = response.data.message;
                               });       
                   },function(response){
                	   alert(response.data.message);
                          $scope.formValue = response.data.message;
                   });
       };

});


application.controller("TableGeneratorController", function($scope,$http,$sce) {
       
       $scope.table={};
       $scope.table.noOfRows=null;
       $scope.table.noOfColumns = null;
       $scope.table.message = null;
       
       $scope.csstable={};
       $scope.csstable.borderWidth=null;
       $scope.csstable.borderStyle=null;
       $scope.csstable.borderColor=null;
       $scope.csstable.borderCollapse=null;
       $scope.csstable.tableWidth=null;
       $scope.csstable.tableWidthUnit=null;
       $scope.csstable.tableHeight=null;
       $scope.csstable.tableHeightUnit=null;
       $scope.csstable.horizontalAlign=null;
       $scope.csstable.verticalAlign=null;
       $scope.csstable.tablePadding=null;
       $scope.csstable.tablePaddingUnit=null;
       $scope.csstable.horizontalDividers=null;
       $scope.csstable.horizontalborderWidth=null;
       $scope.csstable.horizontalborderStyle=null;
       $scope.csstable.horizontalborderColor=null;
       $scope.csstable.hovertable=null;
       $scope.csstable.hovertableColor=null;
       $scope.csstable.stripedtable=null;
       $scope.csstable.stripedtableColor=null;
       $scope.csstable.stripedtableValue=null;
       $scope.csstable.tableBackgroundColor=null;
       $scope.csstable.tableTextColor=null;
       $scope.csstable.responsivetable=null;
       $scope.csstable.message=null;
       
       $scope.tableClickFunction= function()
       {
              var data = JSON.stringify($scope.table);
              $http.post(URI+"Table/table",data).then(
                           function(response){
                                  alert(response.data.message);
                                  $scope.table.message = response.data.message;
                           },function(response){
                        	   	alert(response.data.message);
                                  $scope.table.message = response.data.message;
                           });
       };
       
       $scope.csstableClickFunction= function()
       {
              if($scope.csstable.borderWidth!=null){
                     $scope.csstable.borderWidth = $scope.csstable.borderWidth.toString();
              }
              if($scope.csstable.horizontalborderWidth!=null){
                     $scope.csstable.horizontalborderWidth=$scope.csstable.horizontalborderWidth.toString();
              }
              
              var data = JSON.stringify($scope.csstable);
              $http.post(URI+"Table/csstable",data).then(
                           function(response){
                                  alert(response.data.message);
                                  $scope.table.message = response.data.message;
                           },function(response){
                        	   alert(response.data.message);
                                  $scope.table.message = response.data.message;
                           });
       };

       $scope.myfunc= function()
       {
              $http.get(URI+"Table/Table.html").then(
                
                function(response){
                       //alert(response.data);
                var data1=response.data;
                    var len=data1.indexOf("head");
                    var str1 = data1.substring(0,len+5);
                    $http.get(URI+"Table/TableCSS.css").then(
                            function(response){
                            var data2=response.data;
                            var len1=data2.indexOf("}");
                                var str2 = str1+"<style> #prev "+data2.substring(0,len1+1);
                                while(len1>0){
                                    var sbstr1 = data2.substring(len1+1);
                                    var len1 = sbstr1.indexOf("}");
                                    str2 = str2+"#prev "+sbstr1.substring(0,len1+1);
                                    data2 = sbstr1;
                                }
                                var indexf = str2.lastIndexOf("#prev ");
                                var str3 = str2.substring(0,indexf);
                                str3 = str3+"</style>"+data1.substring(len+5);
                                var len2 = str3.indexOf("<body>");
                                var str4 = str3.substring(0,len2+6)+" <div id=\"prev\" >";
                                //alert(str4);
                                var len3 = str3.indexOf("</body>");
                                str4 = str4+str3.substring(len2+6,len3)+"</div></body></html>";
                                
                                $scope.tableValue =  $sce.trustAsHtml(str4);
                               
                             
                            },function(response){
                            	alert(response.data.message);
                                  $scope.tablecssValue = response.data.message;
                            });       
                },function(response){
                	alert(response.data.message);
                       $scope.tableValue = response.data.message;
                });
};
});

application.controller("LinkGeneratorController",function($scope,$http,$sce){
    $scope.link={};
    $scope.link.url=null;
    $scope.link.text= null;
    $scope.link.rel= null;
    $scope.link.title= null;
    $scope.link.target= null;
    $scope.link.isVisible = false;
    $scope.link.message = null;
    $scope.linkcss={};
    $scope.linkcss.link="#000000";
    $scope.linkcss.visited= "#000000";
    $scope.linkcss.hover= "#000000";
    $scope.linkcss.active= "#000000";
    $scope.linkcss.textDecoration= null;
    $scope.linkcss.backgroundAnimation=null;
    $scope.linkcss.bgLink="#000000";
    $scope.linkcss.bgVisited= "#000000";
    $scope.linkcss.bgHover= "#000000";
    $scope.linkcss.bgActive= "#000000";
    $scope.linkcss.message = null;
    
    $scope.linkClickFunction= function()
    {
   
           var data = JSON.stringify($scope.link);
           $http.post(URI+"Link/link",data).then(
                        function(response){
                               alert(response.data.message);
                               $scope.link.message = response.data.message;
                        },function(response){
                          alert(response.data.message);
                               $scope.link.message = response.data.message;
                        });
    };
    
    
    $scope.linkCssClickFunction= function()
    {
           var data = JSON.stringify($scope.linkcss);
           $http.post(URI+"Link/linkcss",data).then(
                        function(response){
                               alert(response.data.message);
                               $scope.linkcss.message = response.data.message;
                        },function(response){
                             alert(response.data.message);
                               $scope.linkcss.message = response.data.message;
                        });
    };
    
    $scope.myfunc= function()
    {
      $http.get(URI+"Link/Link.html").then(
             
             function(response){
                    var data1=response.data;
                    var len=data1.indexOf("head");
                    var str1 = data1.substring(0,len+5);
                    $http.get(URI+"Link/LinkCss.css").then(
                            function(response){
                            var data2=response.data;
                            var len1=data2.indexOf("}");
                                var str2 = str1+"<style> #prev "+data2.substring(0,len1+1);
                                while(len1>0){
                                    var sbstr1 = data2.substring(len1+1);
                                    var len1 = sbstr1.indexOf("}");
                                    str2 = str2+"#prev "+sbstr1.substring(0,len1+1);
                                    data2 = sbstr1;
                                }
                                var indexf = str2.lastIndexOf("#prev ");
                                var str3 = str2.substring(0,indexf);
                                str3 = str3+"</style>"+data1.substring(len+5);
                                var len2 = str3.indexOf("<body>");
                                var str4 = str3.substring(0,len2+6)+" <div id=\"prev\" >";
                                //alert(str4);
                                var len3 = str3.indexOf("</body>");
                                str4 = str4+str3.substring(len2+6,len3)+"</div></body></html>";
                                
                                $scope.linkValue =  $sce.trustAsHtml(str4);
                               
                            
                         },function(response){
                        	 alert(response.data.message);
                               $scope.linkcssValue = response.data.message;
                         });      
             },function(response){
            	 alert(response.data.message);
                    $scope.linkValue = response.data.message;
             });
    };




});

application.controller("ListGeneratorContoller", function($scope,$http,$sce) {
    $scope.list={}
    $scope.csslist={}
    $scope.list.listType=null;
    $scope.list.descItems=null;
    $scope.list.unorderListType=null;
    $scope.list.unorderListItems=null;
    $scope.list.orderedListType=null;
    $scope.list.orderedListItems=null;
    $scope.list.message = null;
    $scope.csslist.listImage=null;
    $scope.csslist.listMarker=null;
    $scope.csslist.listDefault=null;
    $scope.csslist.message = null;
    
    $scope.csslistClickFunction = function()
    {
           var cssdata = JSON.stringify($scope.csslist);
           $http.post(URI+"List/csslist",cssdata).then(
                        function(response){
                        	alert(response.data.message);
                               $scope.csslist.message = response.data.message;
                        },function(response){
                        	alert(response.data.message);
                               $scope.csslist.message = response.data.message;
                        });

          
    };
    
    
    $scope.listClickFunction = function()
    {
           var data = JSON.stringify($scope.list);
           $http.post(URI+"List/list",data).then(
                        function(response){
                               alert(response.data.message);
                               $scope.list.message = response.data.message;
                        },function(response){
                               alert(response.data.message);
                               $scope.list.message = response.data.message;
                        });
           
           
           $scope.list.listType=null;
           $scope.list.descItems=null;
           $scope.list.unorderListType=null;
           $scope.list.unorderListItems=null;
           $scope.list.orderedListType=null;
           $scope.list.orderedListItems=null;
    };
    
    $scope.myfunc= function()
       {
$http.get(URI+"List/List.html").then(
                
                function(response){
                    var data1=response.data;
                    var len=data1.indexOf("head");
                    var str1 = data1.substring(0,len+5);
                    $http.get(URI+"List/Listcss.css").then(
                            function(response){
                            var data2=response.data;
                            var len1=data2.indexOf("}");
                                var str2 = str1+"<style> #prev "+data2.substring(0,len1+1);
                                while(len1>0){
                                    var sbstr1 = data2.substring(len1+1);
                                    var len1 = sbstr1.indexOf("}");
                                    str2 = str2+"#prev "+sbstr1.substring(0,len1+1);
                                    data2 = sbstr1;
                                }
                                var indexf = str2.lastIndexOf("#prev ");
                                var str3 = str2.substring(0,indexf);
                                str3 = str3+"</style>"+data1.substring(len+5);
                                var len2 = str3.indexOf("<body>");
                                var str4 = str3.substring(0,len2+6)+" <div id=\"prev\" >";
                                //alert(str4);
                                var len3 = str3.indexOf("</body>");
                                str4 = str4+str3.substring(len2+6,len3)+"</div></body></html>";
                                
                                $scope.listValue =  $sce.trustAsHtml(str4);
                               
                             
                            },function(response){
                            	alert(response.data.message);
                                  $scope.listcssValue = response.data.message;
                            });       
                },function(response){
                	alert(response.data.message);
                       $scope.listValue = response.data.message;
                });
       };

});

application.controller("ImageGeneratorController",function($scope,$http,$sce) {
    $scope.image={};
    $scope.cssimage={};
    $scope.image.imgSource=null;
    $scope.image.imgDescription=null;
    $scope.image.imgWidth=null;
    $scope.image.imgWidthType="%";
    $scope.image.imgHeight=null;
    $scope.image.imgHeightType="%";
    $scope.image.imgFloat=null;
    $scope.image.message = null;
    
    $scope.cssimage.borderRadius = null;
    $scope.cssimage.filterType = null;
    $scope.cssimage.blurValue = null;
    $scope.cssimage.brightnessValue = null;
    $scope.cssimage.contrastValue = null;
    $scope.cssimage.grayscaleValue = null;
    $scope.cssimage.huerotateValue = null;
    $scope.cssimage.invertValue = null;
    $scope.cssimage.opacityValue = null;
    $scope.cssimage.saturateValue = null;
    $scope.cssimage.sepiaValue = null;
    $scope.cssimage.shadowValue1 = null;
    $scope.cssimage.shadowValue2 = null;
    $scope.cssimage.shadowValue3 = null;
    $scope.cssimage.shadowColor = null;
    $scope.cssimage.polaroid=null;
    $scope.cssimage.flip=null;
    $scope.cssimage.message = null;
    
    $scope.cssimageClickFunction = function()
    {
           var cssdata = JSON.stringify($scope.cssimage);

           $http.post(URI+"Image/cssimage",cssdata).then(
                        function(response){
                               alert(response.data.message);
                               $scope.image.message = response.data.message;
                        },function(response){
                               alert(response.data.message);
                               $scope.image.message = response.data.message;
                        });
           
           $scope.cssimage.borderRadius = null;
           $scope.cssimage.filterType = null;
           $scope.cssimage.blurValue = null;
           $scope.cssimage.brightnessValue = null;
           $scope.cssimage.contrastValue = null;
           $scope.cssimage.grayscaleValue = null;
           $scope.cssimage.huerotateValue = null;
           $scope.cssimage.invertValue = null;
           $scope.cssimage.opacityValue = null;
           $scope.cssimage.saturateValue = null;
           $scope.cssimage.sepiaValue = null;
           $scope.cssimage.shadowValue1 = null;
           $scope.cssimage.shadowValue2 = null;
           $scope.cssimage.shadowValue3 = null;
           $scope.cssimage.shadowColor = null;
           $scope.cssimage.polaroid=null;
           $scope.cssimage.flip=null;
           
    };
    
    
    $scope.imageClickFunction = function()
    {
           var data = JSON.stringify($scope.image);
           $http.post(URI+"Image/image",data).then(
                        function(response){
                               alert(response.data.message);
                               $scope.image.message = response.data.message;
                        },function(response){
                               alert(response.data.message);
                               $scope.image.message = response.data.message;
                        });
    };
    
    $scope.myfunc= function()
       {
       $http.get(URI+"Image/Image.html").then(
                
                function(response){
                    var data1=response.data;
                    var len=data1.indexOf("head");
                    var str1 = data1.substring(0,len+5);
                    $http.get(URI+"Image/Imagecss.css").then(
                            function(response){
                            var data2=response.data;
                            var len1=data2.indexOf("}");
                                var str2 = str1+"<style> #prev "+data2.substring(0,len1+1);
                                while(len1>0){
                                    var sbstr1 = data2.substring(len1+1);
                                    var len1 = sbstr1.indexOf("}");
                                    str2 = str2+"#prev "+sbstr1.substring(0,len1+1);
                                    data2 = sbstr1;
                                }
                                var indexf = str2.lastIndexOf("#prev ");
                                var str3 = str2.substring(0,indexf);
                                str3 = str3+"</style>"+data1.substring(len+5);
                                var len2 = str3.indexOf("<body>");
                                var str4 = str3.substring(0,len2+6)+" <div id=\"prev\" >";
                                //alert(str4);
                                var len3 = str3.indexOf("</body>");
                                str4 = str4+str3.substring(len2+6,len3)+"</div></body></html>";
                                
                                $scope.imageValue =  $sce.trustAsHtml(str4);
                               
                               
                            },function(response){
                            	alert(response.data.message);
                                  $scope.imagecssValue = response.data.message;
                            });       
                },function(response){
                	alert(response.data.message);
                       $scope.imageValue = response.data.message;
                });
       };
    

});


application.controller("ButtonGeneratorController",function($scope,$http,$sce) {
    $scope.button = {};
    $scope.cssbutton = {};
    $scope.button.type = null;
    $scope.button.text = null;
    $scope.button.name = null;
    $scope.button.target = null;
    $scope.button.autofocus = null;
    $scope.button.disabled = null;   
    $scope.button.message = null;
    $scope.isVisible = false;
    
    $scope.cssbutton.type=null;
    $scope.cssbutton.width=null;
    $scope.cssbutton.color="black";
    $scope.cssbutton.fontcolor="black";
    $scope.cssbutton.paddingValue1=null;
    $scope.cssbutton.paddingValue2=null;
    $scope.cssbutton.marginValue1=null;
    $scope.cssbutton.marginValue2=null;
    $scope.cssbutton.textAlign=null;
    $scope.cssbutton.fontSize=null;
    $scope.cssbutton.radius=null;
    $scope.cssbutton.borderSize=null;
    $scope.cssbutton.borderStyle=null;
    $scope.cssbutton.borderColor="black";
    $scope.cssbutton.hoverAnimations=null;
    $scope.cssbutton.hoverTransistion=null;
    $scope.cssbutton.hoverColor="black";
    $scope.cssbutton.Animations=null;
    $scope.cssbutton.Animationstype=null;
    $scope.cssbutton.pressedHoverColor="black";
    $scope.cssbutton.pressedActiveColor="black";
    $scope.cssbutton.pressedTransform=null;
    $scope.cssbutton.fadeInOpacity=null;
    $scope.cssbutton.message=null;
    
    
    $scope.buttonClickFunction = function()
    {
           var data = JSON.stringify($scope.button);
           
           $http.post(URI+"Button/button",data).then(
                        function(response){
                               alert(response.data.message);
                               $scope.button.message = response.data.message;
                        },function(response){
                               alert(response.data.message);
                               $scope.button.message = response.data.message;
                        });
    };
    
    $scope.cssbuttonClickFunction = function()
    {
           var cssdata = JSON.stringify($scope.cssbutton);
           $http.post(URI+"Button/cssbutton",cssdata).then(
                        function(response){
                              alert(response.data.message);
                               $scope.cssbutton.message = response.data.message;
                        },function(response){
                               alert(response.data.message);
                               $scope.cssbutton.message = response.data.message;
                        });
    };
    
    $scope.myfunc= function()
    {
      $http.get(URI+"Button/Button.html").then(
             
             function(response){
             var data1=response.data;
                 var len=data1.indexOf("head");
                 var str1 = data1.substring(0,len+5);
                 $http.get(URI+"Button/Buttoncss.css").then(
                         function(response){
                             var data2=response.data;
                             var len1=data2.indexOf("}");
                             var str2 = str1+"<style> #prev "+data2.substring(0,len1+1);
                             while(len1>0){
                             var sbstr1 = data2.substring(len1+1);
                             var len1 = sbstr1.indexOf("}");
                             str2 = str2+"#prev "+sbstr1.substring(0,len1+1);
                             data2 = sbstr1;
                             }
                             var indexf = str2.lastIndexOf("#prev ");
                             var str3 = str2.substring(0,indexf);
                             str3 = str3+"</style>"+data1.substring(len+5);
                             var len2 = str3.indexOf("<body>");
                             var str4 = str3.substring(0,len2+6)+" <div id=\"prev\" >";
                             //alert(str4);
                             var len3 = str3.indexOf("</body>");
                             str4 = str4+str3.substring(len2+6,len3)+"</div></body></html>";
                        
                             $scope.buttonValue =  $sce.trustAsHtml(str4);
                            
                            
                         },function(response){
                        	 alert(response.data.message);
                               $scope.buttoncssValue = response.data.message;
                         });       
             },function(response){
            	 alert(response.data.message);
                    $scope.buttonValue = response.data.message;
             });
    };

});


application.controller("DivTableGeneratorController", function($scope,$http,$sce) {
       
       $scope.divtable={};
       $scope.divtable.noOfRows=null;
       $scope.divtable.noOfColumns = null;
       $scope.divtable.message = null;
       
       $scope.cssdivtable={};
       $scope.cssdivtable.borderWidth=null;
       $scope.cssdivtable.borderStyle=null;
       $scope.cssdivtable.borderColor=null;
       $scope.cssdivtable.borderCollapse=null;
       $scope.cssdivtable.tableWidth=null;
       $scope.cssdivtable.tableWidthUnit=null;
       $scope.cssdivtable.tableHeight=null;
       $scope.cssdivtable.tableHeightUnit=null;
       $scope.cssdivtable.horizontalAlign=null;
       $scope.cssdivtable.verticalAlign=null;
       $scope.cssdivtable.tablePadding=null;
       $scope.cssdivtable.tablePaddingUnit=null;
       $scope.cssdivtable.horizontalDividers=null;
       $scope.cssdivtable.horizontalborderWidth=null;
       $scope.cssdivtable.horizontalborderStyle=null;
       $scope.cssdivtable.horizontalborderColor=null;
       $scope.cssdivtable.hovertable=null;
       $scope.cssdivtable.hovertableColor=null;
       $scope.cssdivtable.stripedtable=null;
       $scope.cssdivtable.stripedtableColor=null;
       $scope.cssdivtable.stripedtableValue=null;
       $scope.cssdivtable.tableBackgroundColor=null;
       $scope.cssdivtable.tableTextColor=null;
       $scope.cssdivtable.responsivetable=null;
       $scope.cssdivtable.message=null;
       
       $scope.tableClickFunction= function()
       {
              var data = JSON.stringify($scope.divtable);
              $http.post(URI+"DivTable/divtable",data).then(
                           function(response){
                                  alert(response.data.message);
                                  $scope.divtable.message = response.data.message;
                           },function(response){
                        	   alert(response.data.message);
                                  $scope.divtable.message = response.data.message;
                           });
       };
       
       $scope.cssdivtableClickFunction= function()
       {
              if($scope.cssdivtable.borderWidth!=null){
                     $scope.cssdivtable.borderWidth = $scope.cssdivtable.borderWidth.toString();
              }
              if($scope.cssdivtable.horizontalborderWidth!=null){
                  $scope.cssdivtable.horizontalborderWidth=$scope.cssdivtable.horizontalborderWidth.toString();
              }
              
              var data = JSON.stringify($scope.cssdivtable);
              $http.post(URI+"DivTable/cssdivtable",data).then(
                           function(response){
                                  alert(response.data.message);
                                  $scope.cssdivtable.message = response.data.message;
                           },function(response){
                        	   alert(response.data.message);
                                  $scope.cssdivtable.message = response.data.message;
                           });
       };
       
       $scope.myfunc= function()
       {
         $http.get(URI+"DivTable/DivTable.html").then(
                
                function(response){
                var data1=response.data;
                    var len=data1.indexOf("head");
                    var str1 = data1.substring(0,len+5);
                    $http.get(URI+"DivTable/DivTableCSS.css").then(
                            function(response){
                            var data2=response.data;
                            var len1=data2.indexOf("}");
                                var str2 = str1+"<style> #prev "+data2.substring(0,len1+1);
                                while(len1>0){
                                    var sbstr1 = data2.substring(len1+1);
                                    var len1 = sbstr1.indexOf("}");
                                    str2 = str2+"#prev "+sbstr1.substring(0,len1+1);
                                    data2 = sbstr1;
                                }
                                var indexf = str2.lastIndexOf("#prev ");
                                var str3 = str2.substring(0,indexf);
                                str3 = str3+"</style>"+data1.substring(len+5);
                                var len2 = str3.indexOf("<body>");
                                var str4 = str3.substring(0,len2+6)+" <div id=\"prev\" >";
                                //alert(str4);
                                var len3 = str3.indexOf("</body>");
                                str4 = str4+str3.substring(len2+6,len3)+"</div></body></html>";
                                
                                $scope.divtableValue =  $sce.trustAsHtml(str4);
                               
                               
                            },function(response){
                            	alert(response.data.message);
                                  $scope.divtablecssValue = response.data.message;
                            });       
                },function(response){
                	alert(response.data.message);
                       $scope.divtableValue = response.data.message;
                });
    };
});


application.controller("DynamicGeneratorController", function($scope,$http,$sce) {
    $scope.dynamic= {}
    $scope.dynamic.headerName=null
    $scope.dynamic.headerPaddinng1=null
    $scope.dynamic.headerPaddinng2=null
    $scope.dynamic.headerMargin1=null
    $scope.dynamic.headerMargin2=null
    $scope.dynamic.headerBorderRadius=null
    $scope.dynamic.headerBackgroundType=null
    $scope.dynamic.headerBgcolor=null
    $scope.dynamic.headerBorderCheck=null
    $scope.dynamic.headerBorderWidth=null
    $scope.dynamic.headerBorderStyle=null
    $scope.dynamic.headerBorderColor=null
    $scope.dynamic.footerName=null
    $scope.dynamic.footerPadding1=null
    $scope.dynamic.footerPadding2=null
    $scope.dynamic.footerMargin1=null
    $scope.dynamic.footerMargin2=null
    $scope.dynamic.footerBorderRadius=null
    $scope.dynamic.footerBgColor=null
    $scope.dynamic.footerBorderCheck=null
    $scope.dynamic.footerBorderWidth=null
    $scope.dynamic.footerBorderStyle=null
    $scope.dynamic.footerBorderColor=null
    $scope.dynamic.loginCheck=null
    $scope.dynamic.backgroundType=null
    $scope.dynamic.backgroundColor=null
    $scope.dynamic.templateNo=null
    $scope.dynamic.message=null
    
    $scope.dynamicfunc = function(){
    	
    	if($scope.dynamic.headerPaddinng1!=null){
    		$scope.dynamic.headerPaddinng1 = $scope.dynamic.headerPaddinng1.toString();
    	}
    	if($scope.dynamic.headerPaddinng2!=null){
    		$scope.dynamic.headerPaddinng2 = $scope.dynamic.headerPaddinng2.toString();
    	}
    	if($scope.dynamic.headerMargin1!=null){
    		$scope.dynamic.headerMargin1 = $scope.dynamic.headerMargin1.toString();
    	}
    	if($scope.dynamic.headerMargin2!=null){
    		$scope.dynamic.headerMargin2 = $scope.dynamic.headerMargin2.toString();
    	}
    	if($scope.dynamic.headerBorderRadius!=null){
    		$scope.dynamic.headerBorderRadius = $scope.dynamic.headerBorderRadius.toString();
    	}
    	if($scope.dynamic.footerPadding1!=null){
    		$scope.dynamic.footerPadding1 = $scope.dynamic.footerPadding1.toString();
    	}
    	if($scope.dynamic.footerPadding2!=null){
    		$scope.dynamic.footerPadding2 = $scope.dynamic.footerPadding2.toString();
    	}
    	if($scope.dynamic.footerMargin1!=null){
    		$scope.dynamic.footerMargin1 = $scope.dynamic.footerMargin1.toString();
    	}
    	if($scope.dynamic.footerMargin2!=null){
    		$scope.dynamic.footerMargin2 = $scope.dynamic.footerMargin2.toString();
    	}
    	if($scope.dynamic.footerBorderRadius!=null){
    		$scope.dynamic.footerBorderRadius = $scope.dynamic.footerBorderRadius.toString();
    	}
    	if($scope.dynamic.headerBorderWidth!=null){
    		$scope.dynamic.headerBorderWidth = $scope.dynamic.headerBorderWidth.toString();
    	}
    	if($scope.dynamic.footerBorderWidth!=null){
    		$scope.dynamic.footerBorderWidth = $scope.dynamic.footerBorderWidth.toString();
    	}
    	 var data = JSON.stringify($scope.dynamic);
    	$http.post(URI+"Dynamic/dynamic",data).then(function(response){
    		alert(response.data.message);
            $scope.dynamic.message = response.data.message;
    	},function(response){
    		alert(response.data.message);
    		$scope.dynamic.message = response.data.message;
    	});
    };
    
    $scope.refresh=function(){
    	$http.get(URI+"Dynamic/refresh").then(function(response) {
    		alert(response.data);
    	}, function(response) {
    		alert(response.data);
    	});
    };
    
    $scope.preview = function(){
        $http.get(URI+"Dynamic/Dynamic.html").then(function(response) {
              $scope.dynamic.preview = $sce.trustAsHtml(response.data);
       }, function(response) {
              alert(response.data);
              $scope.dynamic.preview = response.data.message;
       });
 };

    
});
