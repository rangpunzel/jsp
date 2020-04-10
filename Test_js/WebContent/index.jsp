<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <title>AdminLTE 3 | Starter</title>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
    <!-- fullCalendar -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar/main.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-daygrid/main.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-timegrid/main.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fullcalendar-bootstrap/main.min.css">
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

  <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="index3.html" class="nav-link">Home</a>
      </li>
      <li class="nav-item d-none d-sm-inline-block">
        <a href="#" class="nav-link">Contact</a>
      </li>
    </ul>

    <!-- SEARCH FORM -->
    <form class="form-inline ml-3">
      <div class="input-group input-group-sm">
        <input class="form-control form-control-navbar" type="search" placeholder="Search" aria-label="Search">
        <div class="input-group-append">
          <button class="btn btn-navbar" type="submit">
            <i class="fas fa-search"></i>
          </button>
        </div>
      </div>
    </form>

    <!-- Right navbar links -->
    <ul class="navbar-nav ml-auto">
      <!-- Messages Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-comments"></i>
          <span class="badge badge-danger navbar-badge">3</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="<%=request.getContextPath()%>/resources/bootstrap/dist/img/user1-128x128.jpg" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Brad Diesel
                  <span class="float-right text-sm text-danger"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">Call me whenever you can...</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="<%=request.getContextPath()%>/resources/bootstrap/dist/img/user8-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  John Pierce
                  <span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">I got your message bro</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <!-- Message Start -->
            <div class="media">
              <img src="<%=request.getContextPath()%>/resources/bootstrap/dist/img/user3-128x128.jpg" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">
                  Nora Silvester
                  <span class="float-right text-sm text-warning"><i class="fas fa-star"></i></span>
                </h3>
                <p class="text-sm">The subject goes here</p>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i> 4 Hours Ago</p>
              </div>
            </div>
            <!-- Message End -->
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Messages</a>
        </div>
      </li>
      <!-- Notifications Dropdown Menu -->
      <li class="nav-item dropdown">
        <a class="nav-link" data-toggle="dropdown" href="#">
          <i class="far fa-bell"></i>
          <span class="badge badge-warning navbar-badge">15</span>
        </a>
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <span class="dropdown-header">15 Notifications</span>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-envelope mr-2"></i> 4 new messages
            <span class="float-right text-muted text-sm">3 mins</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-users mr-2"></i> 8 friend requests
            <span class="float-right text-muted text-sm">12 hours</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item">
            <i class="fas fa-file mr-2"></i> 3 new reports
            <span class="float-right text-muted text-sm">2 days</span>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item dropdown-footer">See All Notifications</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" data-widget="control-sidebar" data-slide="true" href="#"><i
            class="fas fa-th-large"></i></a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="<%=request.getContextPath()%>/resources/bootstrap/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
           style="opacity: .8">
      <span class="brand-text font-weight-light">AdminLTE 3</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          <img src="<%=request.getContextPath()%>/resources/bootstrap/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">Alexander Pierce</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                Starter Pages
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="#" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Active Page</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Inactive Page</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Simple Link
                <span class="right badge badge-danger">New</span>
              </p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Starter Page</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Starter Page</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
         	<div class="col-sm-6">
         		<div class="card card-primary card-outline">
              <div class="card-header">
                <h3 class="card-title">
                  <i class="far fa-chart-bar"></i>
                  Line Chart
                </h3>

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i>
                  </button>
                  <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-times"></i>
                  </button>
                </div>
              </div>
              <div class="card-body">
                <div id="line-chart" style="height: 300px; padding: 0px; position: relative;"><canvas class="flot-base" width="368" height="300" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 368px; height: 300px;"></canvas><canvas class="flot-overlay" width="368" height="300" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 368px; height: 300px;"></canvas><div class="flot-svg" style="position: absolute; top: 0px; left: 0px; height: 100%; width: 100%; pointer-events: none;"><svg style="width: 100%; height: 100%;"><g class="flot-x-axis flot-x1-axis xAxis x1Axis" style="position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px;"><text x="37" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">0</text><text x="96.07407407407408" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">3</text><text x="155.14814814814815" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">5</text><text x="214.22222222222223" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">8</text><text x="269.3197337962963" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">10</text><text x="328.3938078703704" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">13</text></g><g class="flot-y-axis flot-y1-axis yAxis y1Axis" style="position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px;"><text x="1" y="269" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">-1.5</text><text x="1" y="226.66666666666669" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">-1.0</text><text x="1" y="184.33333333333334" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">-0.5</text><text x="5.984375" y="15" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">1.5</text><text x="5.984375" y="142" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">0.0</text><text x="5.984375" y="99.66666666666667" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">0.5</text><text x="5.984375" y="57.333333333333336" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">1.0</text></g></svg></div></div>
              </div>
              <!-- /.card-body-->
            </div>
         	</div>
         	<div class="col-sm-6">
         		<div class="card card-primary card-outline">
              <div class="card-header">
                <h3 class="card-title">
                  <i class="far fa-chart-bar"></i>
                  Bar Chart
                </h3>

                <div class="card-tools">
                  <button type="button" class="btn btn-tool" data-card-widget="collapse">
                    <i class="fas fa-minus"></i>
                  </button>
                  <button type="button" class="btn btn-tool" data-card-widget="remove">
                    <i class="fas fa-times"></i>
                  </button>
                </div>
              </div>
              <div class="card-body">
                <div id="bar-chart" style="height: 300px; padding: 0px; position: relative;"><canvas class="flot-base" width="368" height="300" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 368px; height: 300px;"></canvas><canvas class="flot-overlay" width="368" height="300" style="direction: ltr; position: absolute; left: 0px; top: 0px; width: 368px; height: 300px;"></canvas><div class="flot-svg" style="position: absolute; top: 0px; left: 0px; height: 100%; width: 100%; pointer-events: none;"><svg style="width: 100%; height: 100%;"><g class="flot-x-axis flot-x1-axis xAxis x1Axis" style="position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px;"><text x="136.22585227272725" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">March</text><text x="196.14914772727272" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">April</text><text x="253.8302556818182" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">May</text><text x="18.25426136363636" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">January</text><text x="306.5660511363636" y="294" class="flot-tick-label tickLabel" style="position: absolute; text-align: center;">June</text></g><g class="flot-y-axis flot-y1-axis yAxis y1Axis" style="position: absolute; top: 0px; left: 0px; bottom: 0px; right: 0px;"><text x="8.953125" y="269" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">0</text><text x="8.953125" y="205.5" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">5</text><text x="1" y="15" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">20</text><text x="1" y="142" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">10</text><text x="1" y="78.5" class="flot-tick-label tickLabel" style="position: absolute; text-align: right;">15</text></g></svg></div></div>
              </div>
              <!-- /.card-body-->
            </div>
         	</div>
        </div>
        <!-- /.row -->
        <div class="row">
        	<div class="col-sm-2">
        		<div class="info-box">
	              <span class="info-box-icon bg-info"><i class="far fa-envelope"></i></span>
	
	              <div class="info-box-content">
	                <span class="info-box-text">Messages</span>
	                <span class="info-box-number">1,410</span>
	              </div>
	              <!-- /.info-box-content -->
	            </div>
        	</div>
        	<div class="col-sm-2">
        		<div class="info-box">
	              <span class="info-box-icon bg-success"><i class="far fa-flag"></i></span>
	
	              <div class="info-box-content">
	                <span class="info-box-text">Bookmarks</span>
	                <span class="info-box-number">410</span>
	              </div>
	              <!-- /.info-box-content -->
            	</div>
        	</div>
        	<div class="col-sm-2">
        		<div class="info-box">
              <span class="info-box-icon bg-warning"><i class="far fa-copy"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">Uploads</span>
                <span class="info-box-number">13,648</span>
              </div>
              <!-- /.info-box-content -->
            </div>
        	</div>
        	<div class="col-sm-2">
	        		<div class="info-box">
	              <span class="info-box-icon bg-danger"><i class="far fa-star"></i></span>
	
	              <div class="info-box-content">
	                <span class="info-box-text">Likes</span>
	                <span class="info-box-number">93,139</span>
	              </div>
	              <!-- /.info-box-content -->
	            </div>
        	</div>
        	<div class="col-sm-2">
        		<div class="info-box">
              <span class="info-box-icon bg-info"><i class="far fa-envelope"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">Messages</span>
                <span class="info-box-number">1,410</span>
              </div>
              <!-- /.info-box-content -->
            </div>
        	</div>
        	<div class="col-sm-2">
        		<div class="info-box">
              <span class="info-box-icon bg-success"><i class="far fa-flag"></i></span>

              <div class="info-box-content">
                <span class="info-box-text">Bookmarks</span>
                <span class="info-box-number">410</span>
              </div>
              <!-- /.info-box-content -->
            </div>
        	</div>
        </div><!-- /.row  -->
        <div class="row">
        	<div class="col-md-3">
            <div class="sticky-top mb-3">
              <div class="card">
                <div class="card-header">
                  <h4 class="card-title">Draggable Events</h4>
                </div>
                <div class="card-body">
                  <!-- the events -->
                  <div id="external-events">
                    <div class="external-event bg-success ui-draggable ui-draggable-handle" style="position: relative;">Lunch</div>
                    <div class="external-event bg-warning ui-draggable ui-draggable-handle" style="position: relative;">Go home</div>
                    <div class="external-event bg-info ui-draggable ui-draggable-handle" style="position: relative;">Do homework</div>
                    <div class="external-event bg-primary ui-draggable ui-draggable-handle" style="position: relative;">Work on UI design</div>
                    <div class="external-event bg-danger ui-draggable ui-draggable-handle" style="position: relative;">Sleep tight</div>
                    <div class="checkbox">
                      <label for="drop-remove">
                        <input type="checkbox" id="drop-remove">
                        remove after drop
                      </label>
                    </div>
                  </div>
                </div>
                <!-- /.card-body -->
              </div>
              <!-- /.card -->
              <div class="card">
                <div class="card-header">
                  <h3 class="card-title">Create Event</h3>
                </div>
                <div class="card-body">
                  <div class="btn-group" style="width: 100%; margin-bottom: 10px;">
                    <!--<button type="button" id="color-chooser-btn" class="btn btn-info btn-block dropdown-toggle" data-toggle="dropdown">Color <span class="caret"></span></button>-->
                    <ul class="fc-color-picker" id="color-chooser">
                      <li><a class="text-primary" href="#"><i class="fas fa-square"></i></a></li>
                      <li><a class="text-warning" href="#"><i class="fas fa-square"></i></a></li>
                      <li><a class="text-success" href="#"><i class="fas fa-square"></i></a></li>
                      <li><a class="text-danger" href="#"><i class="fas fa-square"></i></a></li>
                      <li><a class="text-muted" href="#"><i class="fas fa-square"></i></a></li>
                    </ul>
                  </div>
                  <!-- /btn-group -->
                  <div class="input-group">
                    <input id="new-event" type="text" class="form-control" placeholder="Event Title">

                    <div class="input-group-append">
                      <button id="add-new-event" type="button" class="btn btn-primary">Add</button>
                    </div>
                    <!-- /btn-group -->
                  </div>
                  <!-- /input-group -->
                </div>
              </div>
            </div>
          </div>
          
          <div class="col-md-9">
            <div class="card card-primary">
              <div class="card-body p-0">
                <!-- THE CALENDAR -->
                <div id="calendar" class="fc fc-ltr fc-unthemed" style=""><div class="fc-toolbar fc-header-toolbar"><div class="fc-left"><div class="fc-button-group"><button type="button" class="fc-prev-button fc-button fc-button-primary" aria-label="prev"><span class="fc-icon fc-icon-chevron-left"></span></button><button type="button" class="fc-next-button fc-button fc-button-primary" aria-label="next"><span class="fc-icon fc-icon-chevron-right"></span></button></div><button type="button" class="fc-today-button fc-button fc-button-primary" disabled="">today</button></div><div class="fc-center"><h2>April 2020</h2></div><div class="fc-right"><div class="fc-button-group"><button type="button" class="fc-dayGridMonth-button fc-button fc-button-primary fc-button-active">month</button><button type="button" class="fc-timeGridWeek-button fc-button fc-button-primary">week</button><button type="button" class="fc-timeGridDay-button fc-button fc-button-primary">day</button></div></div></div><div class="fc-view-container"><div class="fc-view fc-dayGridMonth-view fc-dayGrid-view" style=""><table class=""><thead class="fc-head"><tr><td class="fc-head-container fc-widget-header"><div class="fc-row fc-widget-header"><table class=""><thead><tr><th class="fc-day-header fc-widget-header fc-sun"><span>Sun</span></th><th class="fc-day-header fc-widget-header fc-mon"><span>Mon</span></th><th class="fc-day-header fc-widget-header fc-tue"><span>Tue</span></th><th class="fc-day-header fc-widget-header fc-wed"><span>Wed</span></th><th class="fc-day-header fc-widget-header fc-thu"><span>Thu</span></th><th class="fc-day-header fc-widget-header fc-fri"><span>Fri</span></th><th class="fc-day-header fc-widget-header fc-sat"><span>Sat</span></th></tr></thead></table></div></td></tr></thead><tbody class="fc-body"><tr><td class="fc-widget-content"><div class="fc-scroller fc-day-grid-container" style="overflow: hidden; height: 637px;"><div class="fc-day-grid"><div class="fc-row fc-week fc-widget-content" style="height: 106px;"><div class="fc-bg"><table class=""><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-other-month fc-past" data-date="2020-03-29"></td><td class="fc-day fc-widget-content fc-mon fc-other-month fc-past" data-date="2020-03-30"></td><td class="fc-day fc-widget-content fc-tue fc-other-month fc-past" data-date="2020-03-31"></td><td class="fc-day fc-widget-content fc-wed fc-today " data-date="2020-04-01"></td><td class="fc-day fc-widget-content fc-thu fc-future" data-date="2020-04-02"></td><td class="fc-day fc-widget-content fc-fri fc-future" data-date="2020-04-03"></td><td class="fc-day fc-widget-content fc-sat fc-future" data-date="2020-04-04"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-top fc-sun fc-other-month fc-past" data-date="2020-03-29"><span class="fc-day-number">29</span></td><td class="fc-day-top fc-mon fc-other-month fc-past" data-date="2020-03-30"><span class="fc-day-number">30</span></td><td class="fc-day-top fc-tue fc-other-month fc-past" data-date="2020-03-31"><span class="fc-day-number">31</span></td><td class="fc-day-top fc-wed fc-today " data-date="2020-04-01"><span class="fc-day-number">1</span></td><td class="fc-day-top fc-thu fc-future" data-date="2020-04-02"><span class="fc-day-number">2</span></td><td class="fc-day-top fc-fri fc-future" data-date="2020-04-03"><span class="fc-day-number">3</span></td><td class="fc-day-top fc-sat fc-future" data-date="2020-04-04"><span class="fc-day-number">4</span></td></tr></thead><tbody><tr><td class="fc-event-container" rowspan="3"><a class="fc-day-grid-event fc-h-event fc-event fc-not-start fc-end fc-draggable" style="background-color:#f39c12;border-color:#f39c12"><div class="fc-content"> <span class="fc-title">Long Event</span></div></a></td><td rowspan="3"></td><td rowspan="3"></td><td class="fc-event-container"><a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable fc-resizable" style="background-color:#f56954;border-color:#f56954"><div class="fc-content"> <span class="fc-title">All Day Event</span></div><div class="fc-resizer fc-end-resizer"></div></a></td><td class="fc-event-container" rowspan="3"><a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable" style="background-color:#00a65a;border-color:#00a65a"><div class="fc-content"><span class="fc-time">7p</span> <span class="fc-title">Birthday Party</span></div></a></td><td rowspan="3"></td><td rowspan="3"></td></tr><tr><td class="fc-event-container"><a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable" style="background-color:#0073b7;border-color:#0073b7"><div class="fc-content"><span class="fc-time">10:30a</span> <span class="fc-title">Meeting</span></div></a></td></tr><tr><td class="fc-event-container"><a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable" style="background-color:#00c0ef;border-color:#00c0ef"><div class="fc-content"><span class="fc-time">12p</span> <span class="fc-title">Lunch</span></div></a></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content" style="height: 106px;"><div class="fc-bg"><table class=""><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-future" data-date="2020-04-05"></td><td class="fc-day fc-widget-content fc-mon fc-future" data-date="2020-04-06"></td><td class="fc-day fc-widget-content fc-tue fc-future" data-date="2020-04-07"></td><td class="fc-day fc-widget-content fc-wed fc-future" data-date="2020-04-08"></td><td class="fc-day fc-widget-content fc-thu fc-future" data-date="2020-04-09"></td><td class="fc-day fc-widget-content fc-fri fc-future" data-date="2020-04-10"></td><td class="fc-day fc-widget-content fc-sat fc-future" data-date="2020-04-11"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-top fc-sun fc-future" data-date="2020-04-05"><span class="fc-day-number">5</span></td><td class="fc-day-top fc-mon fc-future" data-date="2020-04-06"><span class="fc-day-number">6</span></td><td class="fc-day-top fc-tue fc-future" data-date="2020-04-07"><span class="fc-day-number">7</span></td><td class="fc-day-top fc-wed fc-future" data-date="2020-04-08"><span class="fc-day-number">8</span></td><td class="fc-day-top fc-thu fc-future" data-date="2020-04-09"><span class="fc-day-number">9</span></td><td class="fc-day-top fc-fri fc-future" data-date="2020-04-10"><span class="fc-day-number">10</span></td><td class="fc-day-top fc-sat fc-future" data-date="2020-04-11"><span class="fc-day-number">11</span></td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content" style="height: 106px;"><div class="fc-bg"><table class=""><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-future" data-date="2020-04-12"></td><td class="fc-day fc-widget-content fc-mon fc-future" data-date="2020-04-13"></td><td class="fc-day fc-widget-content fc-tue fc-future" data-date="2020-04-14"></td><td class="fc-day fc-widget-content fc-wed fc-future" data-date="2020-04-15"></td><td class="fc-day fc-widget-content fc-thu fc-future" data-date="2020-04-16"></td><td class="fc-day fc-widget-content fc-fri fc-future" data-date="2020-04-17"></td><td class="fc-day fc-widget-content fc-sat fc-future" data-date="2020-04-18"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-top fc-sun fc-future" data-date="2020-04-12"><span class="fc-day-number">12</span></td><td class="fc-day-top fc-mon fc-future" data-date="2020-04-13"><span class="fc-day-number">13</span></td><td class="fc-day-top fc-tue fc-future" data-date="2020-04-14"><span class="fc-day-number">14</span></td><td class="fc-day-top fc-wed fc-future" data-date="2020-04-15"><span class="fc-day-number">15</span></td><td class="fc-day-top fc-thu fc-future" data-date="2020-04-16"><span class="fc-day-number">16</span></td><td class="fc-day-top fc-fri fc-future" data-date="2020-04-17"><span class="fc-day-number">17</span></td><td class="fc-day-top fc-sat fc-future" data-date="2020-04-18"><span class="fc-day-number">18</span></td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content" style="height: 106px;"><div class="fc-bg"><table class=""><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-future" data-date="2020-04-19"></td><td class="fc-day fc-widget-content fc-mon fc-future" data-date="2020-04-20"></td><td class="fc-day fc-widget-content fc-tue fc-future" data-date="2020-04-21"></td><td class="fc-day fc-widget-content fc-wed fc-future" data-date="2020-04-22"></td><td class="fc-day fc-widget-content fc-thu fc-future" data-date="2020-04-23"></td><td class="fc-day fc-widget-content fc-fri fc-future" data-date="2020-04-24"></td><td class="fc-day fc-widget-content fc-sat fc-future" data-date="2020-04-25"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-top fc-sun fc-future" data-date="2020-04-19"><span class="fc-day-number">19</span></td><td class="fc-day-top fc-mon fc-future" data-date="2020-04-20"><span class="fc-day-number">20</span></td><td class="fc-day-top fc-tue fc-future" data-date="2020-04-21"><span class="fc-day-number">21</span></td><td class="fc-day-top fc-wed fc-future" data-date="2020-04-22"><span class="fc-day-number">22</span></td><td class="fc-day-top fc-thu fc-future" data-date="2020-04-23"><span class="fc-day-number">23</span></td><td class="fc-day-top fc-fri fc-future" data-date="2020-04-24"><span class="fc-day-number">24</span></td><td class="fc-day-top fc-sat fc-future" data-date="2020-04-25"><span class="fc-day-number">25</span></td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content" style="height: 106px;"><div class="fc-bg"><table class=""><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-future" data-date="2020-04-26"></td><td class="fc-day fc-widget-content fc-mon fc-future" data-date="2020-04-27"></td><td class="fc-day fc-widget-content fc-tue fc-future" data-date="2020-04-28"></td><td class="fc-day fc-widget-content fc-wed fc-future" data-date="2020-04-29"></td><td class="fc-day fc-widget-content fc-thu fc-future" data-date="2020-04-30"></td><td class="fc-day fc-widget-content fc-fri fc-other-month fc-future" data-date="2020-05-01"></td><td class="fc-day fc-widget-content fc-sat fc-other-month fc-future" data-date="2020-05-02"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-top fc-sun fc-future" data-date="2020-04-26"><span class="fc-day-number">26</span></td><td class="fc-day-top fc-mon fc-future" data-date="2020-04-27"><span class="fc-day-number">27</span></td><td class="fc-day-top fc-tue fc-future" data-date="2020-04-28"><span class="fc-day-number">28</span></td><td class="fc-day-top fc-wed fc-future" data-date="2020-04-29"><span class="fc-day-number">29</span></td><td class="fc-day-top fc-thu fc-future" data-date="2020-04-30"><span class="fc-day-number">30</span></td><td class="fc-day-top fc-fri fc-other-month fc-future" data-date="2020-05-01"><span class="fc-day-number">1</span></td><td class="fc-day-top fc-sat fc-other-month fc-future" data-date="2020-05-02"><span class="fc-day-number">2</span></td></tr></thead><tbody><tr><td></td><td></td><td class="fc-event-container"><a class="fc-day-grid-event fc-h-event fc-event fc-start fc-end fc-draggable" href="http://google.com/" style="background-color:#3c8dbc;border-color:#3c8dbc"><div class="fc-content"><span class="fc-time">12a</span> <span class="fc-title">Click for Google</span></div></a></td><td></td><td></td><td></td><td></td></tr></tbody></table></div></div><div class="fc-row fc-week fc-widget-content" style="height: 107px;"><div class="fc-bg"><table class=""><tbody><tr><td class="fc-day fc-widget-content fc-sun fc-other-month fc-future" data-date="2020-05-03"></td><td class="fc-day fc-widget-content fc-mon fc-other-month fc-future" data-date="2020-05-04"></td><td class="fc-day fc-widget-content fc-tue fc-other-month fc-future" data-date="2020-05-05"></td><td class="fc-day fc-widget-content fc-wed fc-other-month fc-future" data-date="2020-05-06"></td><td class="fc-day fc-widget-content fc-thu fc-other-month fc-future" data-date="2020-05-07"></td><td class="fc-day fc-widget-content fc-fri fc-other-month fc-future" data-date="2020-05-08"></td><td class="fc-day fc-widget-content fc-sat fc-other-month fc-future" data-date="2020-05-09"></td></tr></tbody></table></div><div class="fc-content-skeleton"><table><thead><tr><td class="fc-day-top fc-sun fc-other-month fc-future" data-date="2020-05-03"><span class="fc-day-number">3</span></td><td class="fc-day-top fc-mon fc-other-month fc-future" data-date="2020-05-04"><span class="fc-day-number">4</span></td><td class="fc-day-top fc-tue fc-other-month fc-future" data-date="2020-05-05"><span class="fc-day-number">5</span></td><td class="fc-day-top fc-wed fc-other-month fc-future" data-date="2020-05-06"><span class="fc-day-number">6</span></td><td class="fc-day-top fc-thu fc-other-month fc-future" data-date="2020-05-07"><span class="fc-day-number">7</span></td><td class="fc-day-top fc-fri fc-other-month fc-future" data-date="2020-05-08"><span class="fc-day-number">8</span></td><td class="fc-day-top fc-sat fc-other-month fc-future" data-date="2020-05-09"><span class="fc-day-number">9</span></td></tr></thead><tbody><tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr></tbody></table></div></div></div></div></td></tr></tbody></table></div></div></div>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
        </div><!-- /.row  -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
  <!-- /.control-sidebar -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="float-right d-none d-sm-inline">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2014-2019 <a href="https://adminlte.io">AdminLTE.io</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>
