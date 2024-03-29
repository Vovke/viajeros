								
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

	<jsp:include page="HeadContent.jsp" />
	
</head>
      
    <body>
    
	<jsp:include page="Header.jsp" />

    <div id="wrapper">
    
    	<jsp:include page="Menu.jsp" />


        <!--Body content-->
        <div id="content" class="clearfix">
            <div class="contentwrapper"><!--Content wrapper-->

                <div class="heading">

                    <h3>Transportation Rate</h3>                    

                    <div class="resBtnSearch">
                        <a href="#"><span class="icon16 brocco-icon-search"></span></a>
                    </div>

                    <div class="search">

                        <form id="searchform" action="search.html" />
                            <input type="text" id="tipue_search_input" class="top-search" placeholder="Search here ..." />
                            <input type="submit" id="tipue_search_button" class="search-btn" value="" />
                        </form>
                
                    </div><!-- End search -->
                    
                    <ul class="breadcrumb">
                        <li>You are here:</li>
                        <li>
                            <a href="#" class="tip" title="back to dashboard">
                                <span class="icon16 icomoon-icon-screen"></span>
                            </a> 
                            <span class="divider">
                                <span class="icon16 icomoon-icon-arrow-right"></span>
                            </span>
                        </li>
                        <li class="active">Transportation Rate</li>
                    </ul>

                </div><!-- End .heading-->

                <!-- Build page from here: -->
                <div class="row-fluid">
                	<div class="span12">

                            <div class="box gradient">

                                <div class="title">
                                    
                                    <h4 class="clearfix"><span class="left">Transportation Rate View/Edit</span>
                                    <a href="<s:url action='listTransportationRate' />" class="right box-form">
                                    	<button class="btn btn-info"><span class="icon16 typ-icon-back white"></span> Back</button>
                                	</a>
                                    </h4>
                                </div>

							<div class="content noPad clearfix">

								<s:form action="saveTransportationRate"	cssClass="form-horizontal">
									<s:select name="transportationRate.sourceId"  list ="destinationIdList" listKey="destinationId" listValue="name" 
									 headerKey="-1"	headerValue="-- Select Source --" label="Source" />

									<s:select name="transportationRate.destinationId" list ="destinationIdList" listKey="destinationId" listValue="name"
										headerKey="-1"	headerValue="-- Select Destination --" label="Destination" />
									
									<s:select name="transportationRate.clientId" list="clientIdList"  listKey="clientId" listValue="clientName"
									headerKey="-1" headerValue="-- Select Client --" label="Client" />

									<s:select name="transportationRate.vehicleTypeId" list="vehicletypeIdList"  listKey="vehicleTypeId" listValue="name"
									headerKey="-1" headerValue="-- Select Vehicle Type --" label="Vehicle Type" />

									<s:textfield name="transportationRate.amount" label="Amount" />
									<s:hidden name="transportationRate.transportationRateId" />
									<s:hidden name="transportationRate.version" />
									<s:submit type="button" value="Save Changes"/>
								</s:form>
							</div>

						</div>
                     </div>

                                       
                </div>
                
            </div><!-- End contentwrapper -->
        </div><!-- End #content -->
    
    </div><!-- End #wrapper -->
    
   	<jsp:include page="Footer.jsp" />
   	
  
   	
    </body>
</html>								