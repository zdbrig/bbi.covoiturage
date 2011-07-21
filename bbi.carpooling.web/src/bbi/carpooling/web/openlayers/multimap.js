













window.MM_DOMAIN_NAME = 'developer.multimap.com';



window.MM_PROTOCOL = 'http';


window.MM_BIRDSEYE_ENABLED = true;

window.MM_LITE_ENABLED = false;


window.MM_STATUS = 'developer';
window.MM_CLIENT_NAME = 'OA10072915821139765';



window.MM_BETA = '';

if( ! window.MM_DATA_PREFS )
  window.MM_DATA_PREFS = {};

window.MM_DATA_PREFS['OA10072915821139765'] = { 'map' : [ 868,866,819,867,826,818,821,863,856,861,858,845,848,847,846,862,841,837,902,915,1004,910,911,1001,916,917,904,1000 ], 'aerial' : [ 1002 ], 'hybrid' : [ 1003 ] };

window.MM_VE_GENERATION = '716';
window.MM_PARENT_DELIVERY_ID = '2011071710006662630';
window.MM_SERVICE_SEQ = '22926';


window.MM_LOCALE = "en-us";

if (!window.MM_DISTANCE_UNIT)
    window.MM_DISTANCE_UNIT = 'miles';

if (!window.MM_WEATHER_UNIT)
    window.MM_WEATHER_UNIT = 'fahrenheit';


window.MM_API_PREFS = { 'MM_WORLD_MAP' : 'multimap', 'MM_WORLD_AERIAL' : 'virtualearth', 'MM_WORLD_HYBRID' : 'virtualearth' };



function MMIsSupportedBrowser() {
  if( navigator.userAgent.indexOf( 'Netscape6' ) >= 0 )
    return false;
  if (document.attachEvent || document.addEventListener) {
    if (typeof(document.doctype)=='object' || typeof(document.media)=='string') {
      if( document.getElementById ) {
        return true;
      }
    }
  }
  return false;
}

(function () {
  var version = '1.2';

  if( version == 1.2 ) {
    var build = '189';
    version = version + '.' + build;
  }

  

  window.MM_VALID_URLS = "http://cz.multimap.com,https://cz.multimap.com,http://preview.multimap.com,https://preview.multimap.com,http://clients.multimap.com,https://clients.multimap.com,http://cz.multimap.local,https://cz.multimap.local,http://preview.multimap.local,https://preview.multimap.local,http://clients.multimap.local,https://clients.multimap.local,http://china.cz.multimap.com,https://china.cz.multimap.com,http://china.clients.multimap.com,https://china.clients.multimap.com,h,f";
  window.MM_API_LOGO = "/i/bing_maps.png";

  if( ! MMIsSupportedBrowser() )
    return;

  
  window.MM_STATIC_CDN = true;
  

  
  var js_host = 's0.cdn.multimap.com';
  

  
  window.MM_TILE_CDN_DOMAIN = 'tiles-cdn.multimap.com';
  

  window.MM_ZIP_DOMAIN = js_host;
  var onload = '';
  if( onload != '' ) {
    window.MMonload = onload;
  }

  
  var url = window.MM_PROTOCOL+'://'+js_host+'/APIJS/'+version+'/obfuscated-mmviewer.'+window.MM_LOCALE+'.js';
  
  function loadJS( url ) {
    if( onload == '' && document.write ) {
      document.write( '<'+'script src="'+url+'" language="JavaScript" type="text/javascript"' + '></'+'script>' );
    } else {
      var script_tag = document.createElement( 'script' );
      script_tag.setAttribute( 'type', 'text/javascript' );
      script_tag.setAttribute( 'language', 'Javascript' );
      script_tag.setAttribute( 'src', url );
      var head_tags = document.getElementsByTagName( 'head' );
      if( head_tags && head_tags.length > 0 )
        head_tags[0].appendChild( script_tag );
    }
  }
  loadJS(url);

  


    
        window.MM_VE_CLIENT_TOKEN = '';
    


})();


window.MM_LOCALINFO_DEFAULT_LIST = 'mm.poi.*';
window.MM_LI_STUBS = {
    'marker_title' : function( p ) { return p['title']; },
    'poi_title' : function( p ) { return p['marker_text']; },
    'poi_ib' : function( p ) { return p['infobox_html']; }
};
window.MM_LOCALINFO_DEFAULTS = [
    {
        'prefix' : 'mm.poi.*',
        'widget_icon' : '/i/holder.png'
     },
    {
        'prefix' : 'mm.poi',
        'identifier' : 'Id',
        'className' : 'MMli-poi',
        'icon' : function( ds ){return '/i/marker.png';},
        'print_icon' : function( ds ){return '/i/poi/markers/'+ds+'.gif';},
        'widget_icon' : function( ds ){return '/i/poi/icons/'+ds+'.gif';},
        'marker_title' : window.MM_LI_STUBS['poi_title'],
        'html' : window.MM_LI_STUBS['poi_ib']
    },
    {
        'prefix' : '',
        'min_zoom' : 13,
        'widget_icon' : '/i/holder.png'
    }
];
