(function(){
    let map;
    let center = {lat: 49.246292, lng: -123.116226}; // "map center on <49.246292, -123.116226>"
    let zoom = 11; // "map zoom-level 11"
    let markers = [
        {
            title: "UBC", // "create marker on <49.2606, -123.2460> with label 'UBC'"
            coordinates: {
                lat: 49.2606,
                lng: -123.2460
            }
        },
        {
            title: "Pacific Center", // "create marker on <49.2833, -123.1178> with label 'Pacific Center'"
            coordinates: {
                lat: 49.2833,
                lng: -123.1178
            }
        }
    ]
    function initMap() {
        map = new google.maps.Map(document.getElementById('map'), {
            center,
            zoom
        });

        for(var i = 0; i < markers.length; i++) {
            let location = markers[i].coordinates;
            let text = markers[i].title;
            let contentString =
                '<div id="content">'+
                text +
                '</div>';
            let infowindow = new google.maps.InfoWindow();
            let marker = new google.maps.Marker({position: location, map: map, title: text});
            google.maps.event.addListener(marker, 'click', function() {
                infowindow.setContent(contentString);
                infowindow.open(map, marker);
            });
        }
    }

    window.initMap = function() {
        window.initMap = null; //set this to null this so that it can't get called anymore....if you want
        initMap();
    };
})();