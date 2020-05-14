
/**
 * Plugin default options:
 */
$.ui.dynatree.prototype.options = {
	title: "Dynatree", // Tree's name (only used for debug output)
	minExpandLevel: 1, // 1: root node is not collapsible
	imagePath: null, // Path to a folder containing icons. Defaults to 'skin/' subdirectory.
	children: null, // Init tree structure from this object array.
	initId: null, // Init tree structure from a <ul> element with this ID.
	initAjax: null, // Ajax options used to initialize the tree strucuture.
	autoFocus: true, // Set focus to first child, when expanding or lazy-loading.
	keyboard: true, // Support keyboard navigation.
	persist: false, // Persist expand-status to a cookie
	autoCollapse: false, // Automatically collapse all siblings, when a node is expanded.
	clickFolderMode: 1, // 클릭시 폴더모드: [ 1:활성화(activate), 2:확장(expand), *3:활성화하고 확장(activate and expand) ]
	activeVisible: true, // Make sure, active nodes are visible (expanded).
	checkbox: false, // Show checkboxes.
	selectMode: 1, // 선택모드: [ 1:단일(single), *2:다중(multi), 3:다중-계층(multi-hier) ]
	fx: { height: "toggle", duration: 200 }, // 애니메이션(Animations), e.g. *null or { height: "toggle", duration: 200 }
	noLink: false, // Use <span> instead of <a> tags for all nodes
	// Low level event handlers: onEvent(dtnode, event): return false, to stop default processing
	onClick: function(node, e) {  // 노드가 클릭시 호출: [ *null: generate focus, expand, activate, select events. ]
		var targetType = node.getEventTargetType(e); // 클릭한 노드영역
		if (targetType) {
    		node.toggleSelect();
    		if (!node.isExpanded() && targetType == "title")
 	    		node.toggleExpand();
		} else return false;
	},
	onDblClick: null, // (No default actions.)
	onKeydown: null, // null: generate keyboard navigation (focus, expand, activate).
	onKeypress: null, // (No default actions.)
	onFocus: null, // null: set focus to node.
	onBlur: null, // null: remove focus from node.

	// Pre-event handlers onQueryEvent(flag, dtnode): return false, to stop processing
	onQueryActivate: null, // Callback(flag, dtnode) before a node is (de)activated.
	onQuerySelect: null, // Callback(flag, dtnode) before a node is (de)selected.
	onQueryExpand: null, // Callback(flag, dtnode) before a node is expanded/collpsed.

	// High level event handlers
	onPostInit: null, // Callback(isReloading, isError) when tree was (re)loaded.
	onActivate: function(node) {  // 노드가 활성화 되었을 때 호출: [ Callback(dtnode) when a node is activated. ]
		$("#echoActive").text("" + node + " (" + node.getKeyPath()+ ")");
	},
	onDeactivate: null, // Callback(dtnode) when a node is deactivated.
	onSelect: null, // Callback(flag, dtnode) when a node is (de)selected.
	onExpand: null, // Callback(flag, dtnode) when a node is expanded/collapsed.
	onLazyRead: null, // Callback(dtnode) when a lazy node is expanded for the first time.
	onCustomRender: null, // Callback(dtnode) before a node is rendered. Return a HTML string to override.
	onCreate: null, // Callback(dtnode, nodeSpan) after a node was rendered for the first time.
	onRender: null, // Callback(dtnode, nodeSpan) after a node was rendered.
				// postProcess is similar to the standard dataFilter hook,
				// but it is also called for JSONP
	postProcess: null, // Callback(data, dataType) before an Ajax result is passed to dynatree

	// Drag'n'drop support
	dnd: {
		// Make tree nodes draggable:
		onDragStart: null, // Callback(sourceNode), return true, to enable dnd
		onDragStop: null, // Callback(sourceNode)
//		helper: null,
		// Make tree nodes accept draggables
		autoExpandMS: 1000, // Expand nodes after n milliseconds of hovering.
		preventVoidMoves: true, // Prevent dropping nodes 'before self', etc.
		onDragEnter: null, // Callback(targetNode, sourceNode)
		onDragOver: null, // Callback(targetNode, sourceNode, hitMode)
		onDrop: null, // Callback(targetNode, sourceNode, hitMode)
		onDragLeave: null // Callback(targetNode, sourceNode)
	},
	ajaxDefaults: { // Used by initAjax option
		cache: false, // false: Append random '_' argument to the request url to prevent caching.
		timeout: 0, // >0: Make sure we get an ajax error for invalid URLs
		dataType: "json" // Expect json format and pass json object to callbacks.
	},
	strings: {
		loading: "Loading&#8230;",
		loadError: "Load error!"
	},
	generateIds: false, // Generate id attributes like <span id='dynatree-id-KEY'>
	idPrefix: "dynatree-id-", // Used to generate node id's like <span id="dynatree-id-<key>">.
	keyPathSeparator: "/", // Used by node.getKeyPath() and tree.loadKeyPath().
//    cookieId: "dynatree-cookie", // Choose a more unique name, to allow multiple trees.
	cookieId: "dynatree", // Choose a more unique name, to allow multiple trees.
	cookie: {
		expires: null //7, // Days or Date; null: session cookie
//		path: "/", // Defaults to current page
//		domain: "jquery.com",
//		secure: true
	},
	// Class names used, when rendering the HTML markup.
	// Note: if only single entries are passed for options.classNames, all other
	// values are still set to default.
	classNames: {
		container: "dynatree-container",
		node: "dynatree-node",
		folder: "dynatree-folder",
//		document: "dynatree-document",

		empty: "dynatree-empty",
		vline: "dynatree-vline",
		expander: "dynatree-expander",
		connector: "dynatree-connector",
		checkbox: "dynatree-checkbox",
		nodeIcon: "dynatree-icon",
		title: "dynatree-title",
		noConnector: "dynatree-no-connector",

		nodeError: "dynatree-statusnode-error",
		nodeWait: "dynatree-statusnode-wait",
		hidden: "dynatree-hidden",
		combinedExpanderPrefix: "dynatree-exp-",
		combinedIconPrefix: "dynatree-ico-",
		nodeLoading: "dynatree-loading",
//		disabled: "dynatree-disabled",
		hasChildren: "dynatree-has-children",
		active: "dynatree-active",
		selected: "dynatree-selected",
		expanded: "dynatree-expanded",
		lazy: "dynatree-lazy",
		focused: "dynatree-focused",
		partsel: "dynatree-partsel",
		lastsib: "dynatree-lastsib"
	},
	debugLevel: 1,

	// ------------------------------------------------------------------------
	lastentry: undefined
};
//
if( parseFloat($.ui.version) < 1.8 ) {
	$.ui.dynatree.defaults = $.ui.dynatree.prototype.options;
}
