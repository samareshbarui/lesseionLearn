// create basic scene

import { OrbitControls } from "https://threejs.org/examples/jsm/controls/OrbitControls.js";

let camera, scene, renderer, OrbitControlsControls, playImageURL, playVideoURL, texture, video;

const getPlayClass = document.getElementsByClassName("play360");
const closeId = document.getElementById("close360");


if (getPlayClass) {
    for (let i = 0; i < getPlayClass.length; i++) {
        getPlayClass[i].addEventListener("click", run360);
    }
}

if (closeId) {
    closeId.addEventListener("click", close360);
}

function run360() {
    document.getElementById("player360").style.display = "block";

    // create main container DIV
    let containerHTML = document.createElement("div");
    containerHTML.setAttribute("id", 'container');
    document.getElementById("content360").appendChild(containerHTML);

    playImageURL = this.getAttribute("imgsrc");
    playVideoURL = this.getAttribute("videosrc");

   

    setTimeout(() => {

        if (playImageURL) {

            init("image", playImageURL);
            animate();

            document.body.style.overflow = "hidden";

        } else if (playVideoURL) {

            // create video HTML
            let videoHTML = document.createElement("VIDEO");
            videoHTML.setAttribute("src", playVideoURL);
            videoHTML.setAttribute("id", 'player360video');
            videoHTML.setAttribute("controls", "");
            videoHTML.setAttribute("crossOrigin", "anonymous");
            videoHTML.setAttribute("playsinline", "");
            document.getElementById("content360").appendChild(videoHTML);

            setTimeout(function () {
                init("video");
                animate();

                document.body.style.overflow = "hidden";
            }, 500);

        }
    }, 200);

}

function close360() {
    document.getElementById("content360").innerHTML = '';
    document.getElementById("player360").style.display = "none";
    document.body.style.overflow = "auto";
}

// init canvas
function init(type, path) {
    scene = new THREE.Scene();
    camera = new THREE.PerspectiveCamera(75, window.innerWidth / window.innerHeight, 0.1, 1000);
    const container = document.getElementById('container');
    renderer = new THREE.WebGLRenderer({ alpha: true });
    renderer.setPixelRatio(window.devicePixelRatio);

    container.appendChild(renderer.domElement);
    camera.position.z = 5;

    const geometry = new THREE.SphereGeometry(500, 60, 40);
    geometry.scale(- 1, 1, 1);

    // select 360 type and load texture
    switch (type) {
        case "image":
            texture = new THREE.TextureLoader().load(path);
            break;
        case "video":
            video = document.getElementById('player360video');
            texture = new THREE.VideoTexture(video);

            video.play();
            videocontrols();

            break;
        default:
    }

    const material = new THREE.MeshBasicMaterial({ map: texture });
    const mesh = new THREE.Mesh(geometry, material);
    scene.add(mesh);

    // orbit control - Auto Rotate, Auto Rotate Speed, Min & Max Distance
    orbitControls();

    renderer.setSize(window.innerWidth, window.innerHeight);

    window.addEventListener('resize', onWindowResize);
}


function videocontrols() {
    // create controls div
    let videoControlHTML = document.createElement("div");
    videoControlHTML.setAttribute("id", 'videoControls');

    let vcPlayHTML = document.createElement("div");
    vcPlayHTML.setAttribute("id", 'videoPlay');

    let vcPauseHTML = document.createElement("div");
    vcPauseHTML.setAttribute("id", 'videoPause');

    let vcSeekBarHTML = document.createElement("div");
    vcSeekBarHTML.setAttribute("id", 'videoSeekBar');

    let vcSeekBarCurrentHTML = document.createElement("div");
    vcSeekBarCurrentHTML.setAttribute("class", 'current');

    let vcVolumnHTML = document.createElement("div");
    vcVolumnHTML.setAttribute("id", 'videoVolumn');

    let vcMuteHTML = document.createElement("div");
    vcMuteHTML.setAttribute("id", 'videoMute');

    let vcTime = document.createElement("div");
    let vcTimeTotal = document.createElement("div");
    let vcTimeCurrent = document.createElement("div");

    vcTime.setAttribute("id", 'videoTime');
    vcTimeCurrent.setAttribute("class", 'videoTimeCurrent');
    vcTimeTotal.setAttribute("class", 'videoTimeTotal');







    document.getElementById("container").appendChild(videoControlHTML);
    document.getElementById("videoControls").appendChild(vcPlayHTML);
    document.getElementById("videoControls").appendChild(vcPauseHTML);
    document.getElementById("videoControls").appendChild(vcSeekBarHTML);
    document.getElementById("videoSeekBar").appendChild(vcSeekBarCurrentHTML);
    document.getElementById("videoControls").appendChild(vcVolumnHTML);
    document.getElementById("videoControls").appendChild(vcMuteHTML);
    document.getElementById("videoControls").appendChild(vcTime);
    document.getElementById("videoTime").appendChild(vcTimeCurrent);
    document.getElementById("videoTime").appendChild(vcTimeTotal);

    document.getElementsByClassName("videoTimeCurrent")[0].innerHTML = "00:00";
    document.getElementsByClassName("videoTimeTotal")[0].innerHTML = "00:00";


    const videoPlay = document.getElementById('videoPlay');
    const videoPause = document.getElementById('videoPause');
    const videoVolumn = document.getElementById('videoVolumn');
    const videoMute = document.getElementById('videoMute');
    const videoSeekbar = document.getElementById('videoSeekBar');

    // video play function
    videoPlay.addEventListener("click", function () {
        if (video.paused) {
            video.play();
            this.style.display = "none";
            videoPause.style.display = "block"
        }
    });

    // video pause function
    videoPause.addEventListener("click", function () {
        if (!video.paused) {
            video.pause();
            this.style.display = "none";
            videoPlay.style.display = "block"
        }
    });

    // video volum function
    videoVolumn.addEventListener("click", function () {
        if (!video.muted) {
            video.muted = true;
            this.style.display = "none";
            videoMute.style.display = "block"
        }
    });

    // video mute function
    videoMute.addEventListener("click", function () {
        if (video.muted) {
            video.muted = false;
            this.style.display = "none";
            videoVolumn.style.display = "block"
        }
    });


    // check video pause or not then hide or show play button
    if (!video.paused) {
        videoPlay.style.display = "none";
        videoPause.style.display = "block"
    }

    // video seek bar function
    video.addEventListener("timeupdate", function () {
        //console.log(video.currentTime)
        let timePercentage = (video.currentTime / video.duration) * 100;
        vcSeekBarCurrentHTML.style.width = timePercentage + "%"
    });

    // video seek bar click function
    videoSeekbar.addEventListener("click", function (event) {
        let offset = this.offsetLeft;
        let left = (event.pageX - offset);
        let totalWidth = this.offsetWidth;
        let percentage = (left / totalWidth);
        let videoTime = video.duration * percentage;
        video.currentTime = videoTime.toFixed(2);
    });

}


function videoControlsTime() {
    let vcCurrentTime = document.getElementsByClassName("videoTimeCurrent");
    let vcTotalTime = document.getElementsByClassName("videoTimeTotal");


    if (video.readyState === 4) {
        let hour = parseInt((video.duration) / 3600);

        if (hour < 10) {
            if (hour >= 1) {
                hour = "0" + hour + ":";
            } else {
                hour = ""
            }
        } else {
            hour = hour + ":";
        }



        let minute = parseInt((video.duration % 3600) / 60);
        if (minute < 10) {
            minute = "0" + minute + ":";
        } else {
            minute = minute + ":";
        }


        let second = Math.floor(video.duration % 60);
        if (second < 10) {
            second = "0" + second;
        }
        let videoDuration = hour + minute + second;

        vcTotalTime[0].innerHTML = videoDuration

        let hour2 = parseInt((video.currentTime) / 3600);


        if (hour2 < 10) {
            if (hour2 >= 1) {
                hour2 = "0" + hour2 + ":";
            } else {
                hour2 = ""
            }
        } else {
            hour2 = hour2 + ":";
            
        }
        
        let minute2 = parseInt((video.currentTime % 3600) / 60);
        if (minute2 < 10) {
            minute2 = "0" + minute2 + ":";;
        } else {
            minute2 = minute2 + ":";
        }
        let second2 = Math.floor(video.currentTime % 60);
        if (second2 < 10) {
            second2 = "0" + second2;
        }
        let videoCurrntTime = hour2 + minute2 + second2;

        vcCurrentTime[0].innerHTML = videoCurrntTime


        if (Math.round(video.currentTime) >= 3600) {
            document.getElementById("videoTime").classList.add("space");
        } else {
            document.getElementById("videoTime").classList.remove("space");
        }

    }

}


// canvas orbit control
function orbitControls() {
    OrbitControlsControls = new OrbitControls(camera, renderer.domElement);
    OrbitControlsControls.listenToKeyEvents(window);
    OrbitControlsControls.enableDamping = true;
    OrbitControlsControls.dampingFactor = 0.05;
    OrbitControlsControls.autoRotate = true;
    OrbitControlsControls.autoRotateSpeed = 0.2;
    OrbitControlsControls.minDistance = 100;
    OrbitControlsControls.maxDistance = 100;
}


// resize window function
function onWindowResize() {
    camera.aspect = window.innerWidth / window.innerHeight;
    camera.updateProjectionMatrix();

    // canvas size
    renderer.setSize(window.innerWidth, window.innerHeight);
}

// animaiton
function animate() {
    requestAnimationFrame(animate);

    let videoLength = document.getElementById("player360").getElementsByTagName('video').length

    if (videoLength >= 1) {
        if (video.ended) {
            document.getElementById('videoPlay').style.display = "block";
            document.getElementById('videoPause').style.display = "none";
        }

        if (typeof(document.getElementById('videoControls')) != 'undefined' && document.getElementById('videoControls') != null) {
            videoControlsTime();
        }
    }

    
    
    
    OrbitControlsControls.update();

    renderer.render(scene, camera);
};

