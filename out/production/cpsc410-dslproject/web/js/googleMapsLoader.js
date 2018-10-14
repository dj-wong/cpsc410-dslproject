(function(){
    let map;
    // let center = {lat: 49.246292, lng: -123.116226}; // "map center on <49.246292, -123.116226>"
    const mapJSON = new Promise((resolve, reject) => {
        $.getJSON("fixtures/sample.json", json => {
            resolve(json);
        });
    });

    function addContentToInfoWindow(infowindow, element, text, requiresPosition) {
        let contentString =
            '<div id="content">'+
                text +
            '</div>';
        google.maps.event.addListener(element, "click", function(event) {
            infowindow.setContent(contentString);
            if (requiresPosition) {
                infowindow.setPosition(event.latLng);
            }
            infowindow.open(map, requiresPosition ? null: element);
        });
    }

    function initMap() {
        Promise.resolve(mapJSON).then(mapData => {
            const {markers, lines, shapes} = mapData;
             map = new google.maps.Map(document.getElementById("map"));

            const latlngbounds = new google.maps.LatLngBounds();
            const infowindow = new google.maps.InfoWindow();

            google.maps.event.addListener(map, "click", function() {
                infowindow.close();
            });

            const addInfoWindow = (element, text, requiresPosition) => { // HOF to not require infowindow parameter every time
                addContentToInfoWindow(infowindow, element, text, requiresPosition);
            };

            const extendBounds = (locations) => {
                locations.forEach(location => {
                    latlngbounds.extend(location);
                })
            };

            markers.forEach(markerInfo => {
                const location = markerInfo.location;
                const text = markerInfo.text;
                const marker = new google.maps.Marker({position: location, map});
                if (text) {
                    addInfoWindow(marker, text);
                }

                latlngbounds.extend(marker.getPosition());
            });

            shapes.forEach(shapeInfo => {
                const locations = shapeInfo.locations;
                const text = shapeInfo.text;
                const polygon = new google.maps.Polygon({
                    map,
                    paths: locations,
                    strokeColor: '#FF0000',
                    strokeOpacity: 0.8,
                    strokeWeight: 2,
                    fillColor: '#FF0000',
                    fillOpacity: 0.35
                });

                if (text) {
                    addInfoWindow(polygon, text, true);
                }

                extendBounds(polygon.getPath());
            });

            lines.forEach(lineInfo => {
                const locations = lineInfo.locations;
                const text = lineInfo.text;
                const line = new google.maps.Polyline({
                    map,
                    path: locations,
                    geodesic: true,
                    strokeColor: '#FF0000',
                    strokeOpacity: 1.0,
                    strokeWeight: 5
                });

                if (text) {
                    addInfoWindow(line, text, true);
                }

                extendBounds(line.getPath());
            });

            map.fitBounds(latlngbounds)

        });
    }

    window.initMap = function() {
        window.initMap = null; //set this to null this so that it can't get called anymore....if you want
        initMap();
    };
})();