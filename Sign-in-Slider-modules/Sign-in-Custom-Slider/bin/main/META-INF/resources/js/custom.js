// swiper slider (Our World Section, Experiences Section, JioWorld Centre Moments Section, Going Beyond The Conventional Section) starts

function fractionSlider() {

    $('.jwc_swiper_fraction').each(function (index, element) {
        // add dynamic class
        $(this).addClass('jwc_fraction' + index);

        var _swiperContainer = '.jwc_fraction' + index + ' ' + '.swiper-container';
        var _swiperPagination = '.jwc_fraction' + index + ' ' + '.swiper-pagination';
        var _swiperNavigationNext = '.jwc_fraction' + index + ' ' + '.swiper-button-next';
        var _swiperNavigationPrev = '.jwc_fraction' + index + ' ' + '.swiper-button-prev';

        var _swiperSpace = parseInt($('.jwc_fraction' + index).attr('data-space'));
        var _slidesPerView = parseFloat($('.jwc_fraction' + index).attr('data-slides'));

        var _dataInterval = parseInt($('.jwc_fraction' + index).attr('data-interval')) * 1000;


        var _swiperMob = $('.jwc_fraction' + index).attr('data-mob');
        var _slidesPerViewAuto = $('.jwc_fraction' + index).attr('data-slides-auto');
        var _slidesPerViewMob, _swiperSpaceMob, _swiperCenter;

        var _swiperIpad = parseFloat($('.jwc_fraction' + index).attr('data-ipad-slides'));

        if (_swiperMob == "true") {
            if ($(window).width() <= 768) {
                _slidesPerViewMob = 1.5;
                _swiperSpaceMob = 15;
                _swiperCenter = true;
            }
        } else {
            if ($(window).width() <= 768) {
                _slidesPerViewMob = 1.1;
                _swiperSpaceMob = 20;
                _swiperCenter = false;
            }
        }

        if (_slidesPerViewAuto == "true") {
            _slidesPerView = "auto";

            if ($(window).width() <= 768) {
                _slidesPerViewMob = "auto";
            }
        }



        var _fractionSlider = new Swiper(_swiperContainer, {
            pagination: {
                el: _swiperPagination,
                type: 'fraction',
            },
            navigation: {
                nextEl: _swiperNavigationNext,
                prevEl: _swiperNavigationPrev,
            },
            keyboard: {
                enabled: true,
            },
            autoplay: {
                delay: _dataInterval,
                disableOnInteraction: false
            },
            slidesPerView: _slidesPerViewMob,
            spaceBetween: _swiperSpaceMob,
            centeredSlides: _swiperCenter,
            autoHeight: true,
            grabCursor: true,
            loop: true,
            speed: 800,
            breakpoints: {
                768: {
                    slidesPerView: _swiperIpad,
                    spaceBetween: _swiperSpace,
                },
                1025: {
                    slidesPerView: _slidesPerView,
                    spaceBetween: _swiperSpace,
                },
            },
            observer: true,
            observeParents: true,
            observeSlideChildren: true,
            updateOnWindowResize: true
        });

    })
}

// swiper slider (Our World Section, Experiences Section, JioWorld Centre Moments Section, Going Beyond The Conventional Section) ends

// noraml slider (What’s On Sections, More at JioWorld Centre Section, Upcoming Events Section) starts

function normalSlider() {

    $('.jwc_swiper_normal').each(function (index, element) {
        // add dynamic class
        $(this).addClass('jwc_normal' + index);

        var _swiperContainer = '.jwc_normal' + index + ' ' + '.swiper-container';
        var _swiperPagination = '.jwc_normal' + index + ' ' + '.swiper-pagination';
        var _swiperNavigationNext = '.jwc_normal' + index + ' ' + '.swiper-button-next';
        var _swiperNavigationPrev = '.jwc_normal' + index + ' ' + '.swiper-button-prev';

        var _swiperSpace = parseInt($('.jwc_normal' + index).attr('data-space'));
        var _slidesPerView = parseFloat($('.jwc_normal' + index).attr('data-slides'));
        var _swiperAutoplay = $('.jwc_normal' + index).attr('data-autoplay');
        var _slidesPerViewMob, _swiperSpaceMob;

        var _swiperIpad = parseFloat($('.jwc_normal' + index).attr('data-ipad-slides'));
        var _swiperIpadSpace = parseInt($('.jwc_normal' + index).attr('data-ipad-space'));

        var _swiperMobile = parseFloat($('.jwc_normal' + index).attr('data-mobile-slides'));
        var _swiperMobileSpace = parseInt($('.jwc_normal' + index).attr('data-mobile-space'));

        var _dataInterval3 = parseInt($('.jwc_normal' + index).attr('data-interval')) * 1000;

        var _swiperMob3 = $('.jwc_normal' + index).attr('data-mob');

        if (_swiperAutoplay == "true") {
            var _boolean = true;
            if ($(window).width() < 768) {
                _slidesPerViewMob = 1;
                _swiperSpaceMob = 0;
            }
        } else {
            if ($(window).width() < 768) {
                _slidesPerViewMob = 1.15;
                _swiperSpaceMob = 10;
            }
        }


        if (!_swiperMob3 == "true") {
            if ($(window).width() < 500) {
                _slidesPerViewMob = 1.15;
                _swiperSpaceMob = 20;
                _swiperCenter3 = false;
            }
        }

        options = {
            slidesPerView: _slidesPerViewMob,
            spaceBetween: _swiperSpaceMob,
            navigation: {
                nextEl: _swiperNavigationNext,
                prevEl: _swiperNavigationPrev,
            },
            speed: 800,
            centeredSlides: true,
            loop: true,
            autoplay: {
                delay: _dataInterval3,
                disableOnInteraction: false
            },
            grabCursor: true,
            pagination: {
                el: _swiperPagination,
                clickable: true,
            },
            breakpoints: {
                320: {
                    slidesPerView: _swiperMobile,
                    spaceBetween: _swiperMobileSpace,
                },
                768: {
                    slidesPerView: _swiperIpad,
                    spaceBetween: _swiperIpadSpace,
                },
                1025: {
                    slidesPerView: _slidesPerView,
                    spaceBetween: _swiperSpace,
                },
            }
        }
        var _normalSlider = new Swiper(_swiperContainer, options);

        if ($(this).hasClass("single_image")) {
            _normalSlider.unsetGrabCursor();
            _normalSlider.allowTouchMove = false
        }

        if (_dataInterval3 === 0) {
            _normalSlider.autoplay.stop();
        }
    })
}
// noraml slider (What’s On Sections, More at JioWorld Centre Section, Upcoming Events Section) ends

// Image swiper (Benefits & Privileges Section, Where Events Come to Life Section, explore venu page kma_textual_slider) starts
function benefitsSwiper() {

    $('.jwc_swiper_benefits').each(function (index, element) {
        // add dynamic class
        $(this).addClass('jwc_benefits' + index);

        var interleaveOffset = 1;
        var _swiperContainer = '.jwc_benefits' + index + ' ' + '.swiper-container';
        var _dataInterval = parseInt($('.jwc_benefits' + index).attr('data-interval')) * 1000;
        var _swiperPagination2 = '.jwc_benefits' + index + ' ' + '.swiper-pagination';
        var _swiperNavigationNext2 = '.jwc_benefits' + index + ' ' + '.swiper-button-next';
        var _swiperNavigationPrev2 = '.jwc_benefits' + index + ' ' + '.swiper-button-prev';

        var benefitsSwiper = new Swiper(_swiperContainer, {
            loop: true,
            speed: 1000,
            grabCursor: true,
            watchSlidesProgress: true,
            mousewheelControl: true,
            keyboardControl: true,
            pagination: {
                el: _swiperPagination2,
                clickable: true
            },
            navigation: {
                nextEl: _swiperNavigationNext2,
                prevEl: _swiperNavigationPrev2
            },
            on: {
                progress: function () {
                    var swiper = this;
                    for (var i = 0; i < swiper.slides.length; i++) {
                        var slideProgress = swiper.slides[i].progress;
                        var innerOffset = swiper.width * interleaveOffset;
                        var innerTranslate = slideProgress * innerOffset;
                        swiper.slides[i].querySelector(".benefits_slider_each").style.transform =
                            "translate3d(" + innerTranslate + "px, 0, 0)";
                    }
                },
                touchStart: function () {
                    var swiper = this;
                    for (var i = 0; i < swiper.slides.length; i++) {
                        swiper.slides[i].style.transition = "";
                    }
                },
                setTransition: function (speed) {
                    var swiper = this;
                    for (var i = 0; i < swiper.slides.length; i++) {
                        swiper.slides[i].style.transition = speed + "ms";
                        swiper.slides[i].querySelector(".benefits_slider_each").style.transition =
                            speed + "ms";
                    }
                }
            }
        });

        if (_dataInterval > 0) {
            setTimeout(function () {
                benefitsSwiper.autoplay.start();
            }, _dataInterval);
        }

        if ($(this).hasClass("single_image")) {
            benefitsSwiper.unsetGrabCursor();
            benefitsSwiper.allowTouchMove = false
        }


    })



}

// Image swiper (Benefits & Privileges Section, Where Events Come to Life Section explore venu page kma_textual_slider) ends

// Image swiper (accordian with slider - plan your next big events) starts
function accordianWithSlider(slideName) {

    var interleaveOffset2 = 1;
    var _swiperContainer2 = '.' + slideName + ' ' + '.swiper-container';
    var _dataInterval2 = parseInt($('.' + slideName).attr('data-interval')) * 1000;

    var accordianSlider = new Swiper(_swiperContainer2, {
        init: false
    });



    $(".accordian_with_slider [data-target]").click(function () {

        var getId = $(this).attr("data-target");
        var findIdInTabDetails = $(this).parents(".accordian_with_slider").find(getId).attr("id");

        if (getId === ("#" + findIdInTabDetails)) {

            accordianSlider = new Swiper(_swiperContainer2, {
                init: false
            });

            _swiperContainer2 = '#' + findIdInTabDetails + ' ' + '.' + slideName + ' ' + '.swiper-container';

            setTimeout(function () {

                accordianSlider = new Swiper(_swiperContainer2, {
                    init: true,
                    loop: false,
                    speed: 1000,
                    grabCursor: true,
                    mousewheelControl: true,
                    keyboardControl: true,
                    observer: true,
                    observeParents: true,
                    observeSlideChildren: true,
                    watchOverflow: true,
                    pagination: {
                        el: '.' + slideName + ' ' + '.swiper-pagination',
                        clickable: true
                    },
                    navigation: {
                        nextEl: '.' + slideName + ' ' + '.swiper-button-next',
                        prevEl: '.' + slideName + ' ' + '.swiper-button-prev'
                    },
                    on: {
                        progress: function () {
                            var swiper2 = this;
                            for (var i = 0; i < swiper2.slides.length; i++) {
                                var slideProgress2 = swiper2.slides[i].progress;
                                var innerOffset2 = swiper2.width * interleaveOffset2;
                                var innerTranslate = slideProgress2 * innerOffset2;
                                swiper2.slides[i].querySelector(".accordian_slider_each").style.transform =
                                    "translate3d(" + innerTranslate + "px, 0, 0)";
                            }
                        },
                        touchStart: function () {
                            var swiper2 = this;
                            for (var i = 0; i < swiper2.slides.length; i++) {
                                swiper2.slides[i].style.transition = "";
                            }
                        },
                        setTransition: function (speed) {
                            var swiper2 = this;
                            for (var i = 0; i < swiper2.slides.length; i++) {
                                swiper2.slides[i].style.transition = speed + "ms";
                                swiper2.slides[i].querySelector(".accordian_slider_each").style.transition =
                                    speed + "ms";
                            }
                        }
                    }
                })




            }, 100);

            if (_dataInterval2 > 0) {
                setTimeout(function () {
                    accordianSlider.autoplay.start();
                }, _dataInterval2);
            }



        }

    });

    $(".accordian_with_slider .card:first-child [data-target]").click();
    $(".accordian_with_slider .card:first-child [data-target]").removeClass("collapsed");
}
// Image swiper (accordian with slider - plan your next big events) ends

// screen visible height starts
function setHeight(height) {
    windowHeight = $(window.top).height() - 60;
    var _height = '.' + height;
    $(_height).css({
        'height': windowHeight,
        'overflow': 'hidden'
    })
};
// screen visible height ends

// screen visible height inside navigation starts
function setHeightInsideNav(height) {
    windowHeight = $(window.top).height() - 130;
    windowHeightMobile = $(window.top).height() - 110;
    windowWidth = $(window).width();
    var _height = '.' + height;

    if (windowWidth >= 992) {
        $(_height).css({
            'height': windowHeight,
            'overflow': 'hidden'
        })
    } else {
        $(_height).css({
            'height': windowHeightMobile,
            'overflow': 'hidden'
        })
    }
};
// screen visible height inside navigation ends



// screen visible height inside navigation starts
function setHeightThreeQuarters(height) {
    quartersWindowHeight = $(window.top).height() / 3;
    desktopWindowHeight = $(window.top).height() - quartersWindowHeight;
    mobileWindowHeight = $(window.top).height() - quartersWindowHeight - 20;
    windowWidth = $(window).width();
    var _height = '.' + height;
    var videotag = '.' + height + " " + "video";
    var videoparent = $(videotag).parent()

    if (windowWidth >= 992) {
        $(_height).css({
            'height': desktopWindowHeight,
            'overflow': 'hidden'
        })

        $(videoparent).css({
            'height': desktopWindowHeight,
        });

    } else {
        $(_height).css({
            'height': mobileWindowHeight,
            'overflow': 'hidden'
        })

        $(videoparent).css({
            'height': mobileWindowHeight,
        });
    }
};
// screen visible height inside navigation ends



// full width section starts
function fullWidth() {
    var width = ($('.full_width').outerWidth() - $('.full_width .container').outerWidth()) / 2;

    $('.full_width').css({
        'padding-left': width + 15
    })
    $('.full_width .text-center').css({
        'padding-right': width + 15
    })
    $('.verticals_slider .swiper-pagination-fraction, .experiences_slider .swiper-pagination-fraction, .publicsafety_slider .swiper-pagination-fraction').css({
        'left': -(width / 2) - 45
    })

    // feature Show pagination
    $('.featured_shows_slider .swiper-pagination-fraction').css({
        'left': -($('.full_width').outerWidth() - $('.featured_shows_slider').outerWidth() - 20)
    })
}
// full width section ends


// arrows right starts
function arrowsRight() {
    var width = ($('.full_width').outerWidth() - $('.full_width .container').outerWidth()) / 2;
    $('.swiper_fraction .swiper-arrows').css({
        'right': width
    })
}
// arrows right ends


// loader starts
function loader() {
    $('.loader').hide();
}
// loader ends

// normal slider 2 (ACC page - plan your itinerary slider, more at jio slider) starts

function normalSlider2(nsslidesPerView, nsslidesPerViewMobile, nsswiperSpace, nsswiperSpaceMob, nsloop, nscentered, nsgrabCursor, nssimulateTouch) {

    

    $('.jwc_swiper_normal2').each(function (index, element) {
        
        // add dynamic class
        $(this).addClass('jwc_normal2_' + index);

        var _nsswiperContainer = '.jwc_normal2_' + index + ' ' + '.swiper-container';

        var _nsswiperNavigationNext = '.jwc_normal2_' + index + ' ' + '.swiper-button-next';
        var _nsswiperNavigationPrev = '.jwc_normal2_' + index + ' ' + '.swiper-button-prev';

        nsslidesPerView, nsslidesPerViewMobile, nsswiperSpace, nsswiperSpaceMob, nsloop;

        var _normalSlider2 = new Swiper(_nsswiperContainer, {
            slidesPerView: nsslidesPerView,
            spaceBetween: nsswiperSpace,
            speed: 800,
            simulateTouch: nssimulateTouch,
            grabCursor: nsgrabCursor,
            nsloop: nsloop,
            navigation: {
                nextEl: _nsswiperNavigationNext,
                prevEl: _nsswiperNavigationPrev,
            },
            breakpoints: {
                320: {
                    slidesPerView: nsslidesPerViewMobile,
                    spaceBetween: nsswiperSpaceMob,
                    simulateTouch: true,
                    nscenteredSlides: nscentered
                },
                769: {
                    slidesPerView: nsslidesPerView,
                    spaceBetween: nsswiperSpace
                }
            }
        });




    });

    


    

    
}

// normal slider 2 (ACC page - plan your itinerary slider, more at jio slider) ends


// ACC arts slider starts
function nitaArtsSlider(isnideSliderName) {

    var _swiperContainerna = '.' + isnideSliderName + ' ' + '.swiper-container';
    var _swiperPaginationna = '.' + isnideSliderName + ' ' + '.swiper-pagination';

    if ($(window).width() < 767) {
        var _artSlider = new Swiper(_swiperContainerna, {
            init: true,
            slidesPerView: 1.1,
            spaceBetween: 20,
            speed: 800,
            observer: true,
            observeParents: true,
            observeSlideChildren: true,
            simulateTouch: true,
            loop: true,
            pagination: {
                el: _swiperPaginationna
            }
        });
    } else {
        var _artSlider = new Swiper(_swiperContainerna, {
            init: false
        });

        // if window resize from mobile to desktop/laptop then below attrs/classes are removing 
        $(_swiperContainerna).removeClass("swiper-container-initialized swiper-container-horizontal");
        $(_swiperContainerna).find(".swiper-slide-duplicate").remove();
        setTimeout(function () {
            $(_swiperContainerna).find(".swiper-slide").removeAttr("style");
        }, 100);

    }


}
// ACC arts slider ends

// for ACC page add body class when performing visual arts setion available starts
$(document).ready(function () {
    if ($(".performing_visual_arts").length > 0) {
        $("body").addClass("overflow_X_hidden");
    }
});
// for ACC page add body class when performing visual arts setion available ends


AOS.init({
    offset: 0, // offset (in px) from the original trigger point
    delay: 400, // values from 0 to 3000, with step 50ms
    duration: 1000, // values from 0 to 3000, with step 50ms
    easing: 'ease-out-quad', // default easing for AOS animations
    once: false, // whether animation should happen only once - while scrolling down
});


// window scroll function starts
$(window).on("scroll", function () {
    AOS.refresh();
})
// window scroll function ends

//Expand Collapse function starts *on Listing page Explore venu section
function expandcollapse() {
    $('.explorevenues_expand [data-toggle="tab"]').click(function () {
        $(this).parents('.explorevenues_wrapper_each').find('.expandcard').addClass('show');
        var activeexpand = $(this).parents('.explorevenues_wrapper_each').find('.icon-expand');
        activeexpand.addClass('selected');
        if ($(activeexpand).hasClass("selected")) {
            $(activeexpand).addClass("active");
            $(activeexpand).find('span').text("Collapse");
        }
    });

    $('.explorevenues_expand [data-toggle="collapse"]').click(function () {
        $(this).toggleClass("active");

        if ($(this).hasClass("active")) {
            $(this).find('span').text("Collapse");

        } else {
            $(this).find('span').text("Expand");
        }
    });
}

//Expand Collapse function ends

// range slider for convention centre venues page Halls and Rooms section start
function rangeSlider(rangeSliderName) {
    // init slider
    $('#' + rangeSliderName).slider();

    // get current values of range slider
    $('#' + rangeSliderName).on("slideStop", function (number) {
        var startValue = number.value[0];
        var endValue = number.value[1];
        //console.log(startValue + " -- "+ endValue)
    });
}
// range slider for convention centre venues page Halls and Rooms section ends

// convention centre venues page Halls and Rooms section filter starts
function hallRoomFilter() {
    $('.filterBy').click(function () {

        if (!$(this).parents(".eventFiler").hasClass("open")) {
            $(this).parents(".eventFiler").addClass("open");
            $(this).find(".filter").text("Close");
        } else {
            $(this).parents(".eventFiler").removeClass("open");
            $(this).find(".filter").text("Filters");
        }

    });
}
// convention centre venues page Halls and Rooms section filter ends



// garden whats on filter section starts
function gardenWhatsOnFilter() {
    $('.filters').click(function () {

        if (!$(this).parents(".listFilter").hasClass("open")) {
            $(this).parents(".listFilter").addClass("open");
            $(this).find(".filter").text("Close");
        } else {
            $(this).parents(".listFilter").removeClass("open");
            $(this).find(".filter").text("Filters");
        }

    });
}
// garden whats on filter section ends


// custom dropdown starts
function customDropdown() {
    $('.dropdown').on('click', function () {
        $(this).toggleClass("open");
    });

    // select text
    $('.dropdown--list ul li').on('click', function () {
        var getText = $(this).text();
        $(this).parents(".dropdown").find(".dropdown--select").text(getText)
    });

    // if click outside of dropdown then dropdown close
    $(document).on('click', function (event) {
        if (!$(event.target).closest('.dropdown *').length) {
            $('.dropdown').removeClass("open");
        }
    });
}
// custom dropdown ends


// convention centre venues page Halls and Rooms section slider ends
function normalSlider3() {

    $('.tabslider').each(function (index, element) {
        $(this).addClass('tabslider' + index);

        var _swiperContainer3 = '.tabslider' + index + ' ' + '.swiper-container';
        var _swiperPagination3 = '.tabslider' + index + ' ' + '.swiper-pagination';
        var _swiperNavigationNext3 = '.tabslider' + index + ' ' + '.swiper-button-next';
        var _swiperNavigationPrev3 = '.tabslider' + index + ' ' + '.swiper-button-prev';

        var _swiperSpace3 = parseInt($('.tabslider' + index).attr('data-space'));
        var _slidesPerView3 = parseFloat($('.tabslider' + index).attr('data-slides'));

        var _slidesPerViewMob3 = parseFloat($('.tabslider' + index).attr('data-mobile-slides'));
        var _swiperSpaceMob3 = parseInt($('.tabslider' + index).attr('data-mobile-space'));


        var _normalSlider3 = new Swiper(_swiperContainer3, {
            slidesPerView: _slidesPerView3,
            spaceBetween: _swiperSpace3,
            navigation: {
                nextEl: _swiperNavigationNext3,
                prevEl: _swiperNavigationPrev3,
            },
            speed: 800,
            loop: true,
            observer: true,
            observeParents: true,
            observeSlideChildren: true,
            autoplay: false,
            pagination: {
                el: _swiperPagination3,
                clickable: true,
            },
            breakpoints: {
                320: {
                    slidesPerView: _slidesPerViewMob3,
                    spaceBetween: _swiperSpaceMob3,
                },
                768: {
                    slidesPerView: _slidesPerView3,
                    spaceBetween: _swiperSpace3,
                },
            }
        });
    });
}
// convention centre venues page Halls and Rooms section slider ends


// card based slider (CC venues page - meeting section) starts
function cardSlider() {

    $('.cardSlider').each(function (index, element) {

        // add dynamic class
        $(this).addClass('cardSlider' + index);

        var _swiperContainer4 = '.cardSlider' + index + ' ' + '.swiper-container';
        var _swiperNavigationNext4 = '.cardSlider' + index + ' ' + '.swiper-button-next';
        var _swiperNavigationPrev4 = '.cardSlider' + index + ' ' + '.swiper-button-prev';

        var _swiperSpace4 = parseInt($('.cardSlider' + index).attr('data-space'));
        var _slidesPerView4 = parseFloat($('.cardSlider' + index).attr('data-slides'));


        var _slidesPerViewIpad4 = parseFloat($('.cardSlider' + index).attr('data-ipad-slides'));
        var _swiperSpaceIpad4 = parseInt($('.cardSlider' + index).attr('data-ipad-space'));

        var _slidesPerViewMob4 = parseFloat($('.cardSlider' + index).attr('data-mobile-slides'));
        var _swiperSpaceMob4 = parseInt($('.cardSlider' + index).attr('data-mobile-space'));


        var cardSlide = new Swiper(_swiperContainer4, {
            slidesPerView: _slidesPerView4,
            spaceBetween: _swiperSpace4,
            navigation: {
                nextEl: _swiperNavigationNext4,
                prevEl: _swiperNavigationPrev4,
            },
            speed: 800,
            loop: true,
            observer: true,
            observeParents: true,
            observeSlideChildren: true,
            breakpoints: {
                320: {
                    slidesPerView: _slidesPerViewMob4,
                    spaceBetween: _swiperSpaceMob4,
                },
                768: {
                    slidesPerView: _slidesPerViewIpad4,
                    spaceBetween: _swiperSpaceIpad4,
                },
                1024: {
                    slidesPerView: _slidesPerView4,
                    spaceBetween: _swiperSpace4,
                }
            }
        });


    });



    //cardSlide.autoplay.stop();
}
// card based slider (CC venues page - meeting section) ends

// noraml slider4 (news section) starts

function normalSlider4() {


    $('.jwc_swiper_normal4').each(function (index, element) {

        $(this).addClass('jwc_swiper_normal4_' + index);

        var _slidesPerViewMob4, _swiperSpaceMob4;
        var _swiperContainer4 = '.jwc_swiper_normal4_' + index + ' ' + '.swiper-container';

        var _swiperSpace4 = parseInt($('.jwc_swiper_normal4_' + index).attr('data-space'));
        var _slidesPerView4 = parseFloat($('.jwc_swiper_normal4_' + index).attr('data-slides'));

        var _swiperMob4 = parseFloat($('.jwc_swiper_normal4_' + index).attr('data-mob-slides'));
        var _swiperMobSpace4 = parseInt($('.jwc_swiper_normal4_' + index).attr('data-mob-space'));

        var _swiperIpad4 = parseFloat($('.jwc_swiper_normal4_' + index).attr('data-ipad-slides'));
        var _swiperIpadSpace4 = parseInt($('.jwc_swiper_normal4_' + index).attr('data-ipad-space'));

        var _dataInterval4 = parseInt($('.jwc_swiper_normal4_' + index).attr('data-interval')) * 1000;

        var _normalSlider4 = new Swiper(_swiperContainer4, {
            slidesPerView: _slidesPerViewMob4,
            spaceBetween: _swiperSpaceMob4,
            speed: 800,
            //grabCursor: true,
            autoplay: {
                delay: _dataInterval4,
                disableOnInteraction: false
            },
            breakpoints: {
                320: {
                    slidesPerView: _swiperMob4,
                    spaceBetween: _swiperMobSpace4,
                    loop: true,
                    centeredSlides: true
                },
                640: {
                    slidesPerView: _swiperIpad4,
                    spaceBetween: _swiperIpadSpace4,
                },
                1025: {
                    slidesPerView: _slidesPerView4,
                    spaceBetween: _swiperSpace4,
                },
            }
        });


        if (!($(window).width() <= 767)) {
            _normalSlider4.autoplay.stop();
        }

    });



}
// noraml slider (news section) ends

// footer header click false for desktop Starts
function footerCollapseHeader() {
    var windowWidth = $(window).width()

    $('footer .card-header a').click(function () {
        if (!(windowWidth <= 767)) {
            return false;
        }
    });
}

// footer header click false for desktop ends

//Thankyou Modelbox close function Starts
function thankyoucomponent() {
    $('.thankyou_component .icon-xbtn').click(function () {
        $(this).parents('.thankyou_component').hide();
    });
}
//Thankyou Modelbox close function ends

// sidebar coutom drop section starts
function sidebarDrop() {
    $('.list-btn').click(function () {
        if (!$(this).parents(".sidebarlist").hasClass("open")) {
            $(this).parents(".sidebarlist").addClass("open");
        } else {
            $(this).parents(".sidebarlist").removeClass("open");
        }
    });
    // for mobile hide side bar after click
    $('.sidebarnav li a.sidebarnav_link').click(function () {
        if ($(window).width() <= 991) {
            $(this).parents(".sidebarlist").removeClass("open");
        }
    });


}
// sidebar coutom drop section ends


// calendar view start
function calendar() {

    if ($("#calendar").length > 0) {

        var calendarOptions = {
            editable: false,
            selectable: false,
            businessHours: false,
            dayMaxEvents: 1, // allow "more" link when too many events
            fixedWeekCount: false,
            contentHeight: 'auto',
            headerToolbar: {
                start: 'title',
                end: 'prev,next'
            },
            events: [{
                    start: '2020-10-01',
                    description: '<span class="title">Indie Rockers Of Mumbai</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-01',
                    description: '<span class="title">Indie Rockers Of Mumbai 3</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-01',
                    description: '<span class="title">Indie Rockers Of Mumbai 3</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-12',
                    description: '<span class="title">Indie Rockers Of Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-15',
                    description: '<span class="title">Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-02',
                    description: '<span class="title">Indie Rockers Of Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-06',
                    description: '<span class="title">Indie Rockers Of Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-19',
                    description: '<span class="title">Indie Rockers Of Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-19',
                    description: '<span class="title">Indie Rockers Of Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-28',
                    description: '<span class="title">Indie Rockers Of Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-28',
                    description: '<span class="title">Indie Rockers Of Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                },
                {
                    start: '2020-10-28',
                    description: '<span class="title">Indie Rockers Of Mumbai 2</span><span class="date">16th October- 16th October 2020</span><span class="time">6:00 PM - 9:00 PM</span>'
                }
            ],
            eventContent: function (eventInfo) {
                return {
                    html: eventInfo.event.extendedProps.description
                }
            }
        }


        var calendarEl = document.getElementById('calendar');

        var calendar = new FullCalendar.Calendar(calendarEl, calendarOptions);

        if ($(window).width() >= 991) {
            calendarOptions.dayMaxEvents = 1
            calendar = new FullCalendar.Calendar(calendarEl, calendarOptions);
            calendar.render();

        } else {
            calendarOptions.dayMaxEvents = 0
            var calendar = new FullCalendar.Calendar(calendarEl, calendarOptions);
            calendar.render();
        }
    }
}
// calendar view end

// switch between calendar and grid view (garden archive) start
function switchView() {
    // click event
    $(".filter_view_tab a[data-target]").click(function () {
        var gettarget = $(this).attr("data-target");
        $(".filter_view_tab a[data-target]").removeClass("active");
        $(this).parents(".filter_view").find(".filter_view_tab_details .views").removeClass("open");


        $(this).addClass("active");
        $(this).parents(".filter_view").find("#" + gettarget).addClass("open");
    });



    // trigger first click after loading
    $('.filter_view_tab a[data-target]:last-child').click();

    $(document).on('click', ".fc-daygrid-more-link", function () {
        $(".filter_view_tab_details").addClass("zIndex");

        if ($(window).width() <= 767) {
            $("html").css("overflow", "hidden");
            $(".archive").addClass("zIndex999");
        }
    });

    $(document).on('click', ".fc-popover-close", function () {
        $(".filter_view_tab_details").removeClass("zIndex");

        if ($(window).width() <= 767) {
            $("html").css("overflow", "scroll");
            $(".archive").removeClass("zIndex999");
        }

    });



}
// switch between calendar and grid view (garden archive) end


// sticky navbar starts
function stikcyNavbar() {
    // var _navbar = $('.jwc_navbar');

    // $(window).on('scroll', function () {
    //     var st = $(this).scrollTop();
    //     if (st > 10) {
    //         _navbar.addClass('onscroll');
    //     } else {
    //         _navbar.removeClass('onscroll');
    //     }
    // })
}
// sticky navbar ends

// navbar desktop starts
function navabrDesktop() {
    $('.dropdown-toggle').on('mouseenter', function () {
        $(this).next('.dropdown-menu').find('.jwc_navbar_dropdown_list--img img').attr('src', "./assets/images/menu/jioworld-convention-centre.jpg");
    })

    $('.jwc_navbar_dropdown_list').each(function () {
        var _id = "#" + $(this).attr('id'),
            _class = "." + $(this).attr('id');

        $(_id + " li").each(function () {
            $(this).find('a').on('mouseenter', function () {
                var _img = $(this).attr('data-img');
                $(_class).find('img').addClass('active');
                $(_class).find('img').attr('src', "");
                setTimeout(function () {
                    $(_class).find('img').attr('src', _img);
                    $(_class).find('img').removeClass('active');
                }, 300);
            });
        })

        $(this).on('mouseleave', function () {
            $(_class).find('img').attr('src', "./assets/images/menu/jioworld-convention-centre.jpg");
        });
    })

    $('.jwc_dropdown_hover').on('mouseenter', function () {
        $('.jwc_dropdown_hover').removeClass('show');
        $('.jwc_dropdown_hover').find('.jwc_dropdown_hover_content').removeClass('show');
        $(this).addClass('show');
        $(this).find('.jwc_dropdown_hover_content').addClass('show');
    })

    $('.jwc_dropdown_hover_content').on('mouseleave', function () {
        $(this).removeClass('show');
        $(this).parent().removeClass('show');
    })
}

function navabrMobile() {
    $('.jwc_navbar_mobile .dropdown .nav-link').on('click', function () {
        $('.jwc_navbar_mobile .jwc_mobile_menu_scroll').css({
            'overflow': 'hidden'
        })
        setTimeout(function () {
            $('.jwc_navbar_mobile .jwc_mobile_menu_scroll').animate({
                scrollTop: 0
            }, 350);
        }, 500);
    })

    $('.jwc_navbar_mobile .jwc_navbar_list_back').on('click', function () {
        $('.jwc_navbar_mobile .jwc_mobile_menu_scroll').css({
            'overflow-y': 'auto'
        })
    })



    $('.jwc_hamburger').on('click', function () {
        if ($("body").hasClass("notificationOpen")) {
            setTimeout(() => {
                $(this).toggleClass('extra')
            }, 550);
        }
       
    })

    // var lastScrollTop = 0;
    var _navbar = $('.jwc_navbar_brand');

    $(window).on('scroll', function () {

        var st = $(this).scrollTop();
        var notification = $("#website_notification").outerHeight();

        if ($("body").hasClass("notificationOpen")) {

            if (st > notification + 60) {
                _navbar.addClass('jwc_onscroll_nav');
            } else {
                _navbar.removeClass('jwc_onscroll_nav');
            }


        } else {

            if (st > 60) {
                _navbar.addClass('jwc_onscroll_nav');
            } else {
                _navbar.removeClass('jwc_onscroll_nav');
            }

        }


    })
}

if ($(window).width() > 1023) {
    navabrDesktop();
    stikcyNavbar();
} else {
    navabrMobile();
    $('.jwc_dropdown_menu_list a').on('click', function () {
        $('.jwc_dropdown_menu #selected').text($(this).text());
    });
}
// navbar desktop ends



// gallery popup slider starts

function galleryPopupSlider() {

    $('.gallery_popup_slider').each(function (index, element) {
        // add dynamic class
        $(this).addClass('popup_slider' + index);

        var _galleryswiperContainer = '.popup_slider' + index + ' ' + '.swiper-container';
        var _galleryswiperNavigationNext = '.popup_slider' + index + ' ' + '.swiper-button-next';
        var _galleryswiperNavigationPrev = '.popup_slider' + index + ' ' + '.swiper-button-prev';

        var _galleryswiperSpace = parseInt($('.popup_slider' + index).attr('data-space'));
        var _galleryslidesPerView = parseFloat($('.popup_slider' + index).attr('data-slides'));



        options = {
            navigation: {
                nextEl: _galleryswiperNavigationNext,
                prevEl: _galleryswiperNavigationPrev,
            },
            keyboard: {
                enabled: true,
            },
            slidesPerView: _galleryslidesPerView,
            spaceBetween: _galleryswiperSpace,
            autoHeight: true,
            loop: false,
            speed: 800,
            observer: true,
            observeParents: true,
            observeSlideChildren: true
        }

        var _gallerySlider = new Swiper(_galleryswiperContainer, options);


        if ($(this).hasClass("single_image")) {
            _gallerySlider.unsetGrabCursor();
            _gallerySlider.allowTouchMove = false
        }


    })
}

// gallery popup slider ends

// gallery open click event starts
$('#gallery_popup').on('show.bs.modal', function (e) {
    galleryPopupSlider();
})
if ($('.timepicker').length) {
    $('.timepicker').timepicker({
        timeFormat: 'h:mm p',
        change: function (time) {
            // get access to this Timepicker instance
            var timepicker = $(this).timepicker();
            console.log(timepicker.format(time))
        }
    });
}

if ($('[data-toggle="datepicker"]').length) {
    $('[data-toggle="datepicker"]').datepicker({
        autoHide: true,
        autoPick: false,
    });
}


if ($('.jwc_range_slider').length) {
    $(".jwc_range_slider").ionRangeSlider({
        skin: "round",
        // get access to this slider instance
        onFinish: function (data) {
            console.dir(data.from + "---" + data.to);
        }
    });
}

// gallery open click event ends



// load more click starts
function loadMore() {
    $('.load-more-button').on('click', function () {
        $(this).parents(".load-more-data").find(".load-more-data-hide").removeClass("load-more-data-hide");
        $(this).hide();
    })
}
// load more click ends

// click event - Description of gallery archive event start
$('a[data-target="#gallery_popup"]').on('click', function () {
    var attr = $(this).attr('data-des');
    if (typeof attr !== typeof undefined && attr !== false) {
        $("#gallery_popup .jwc_image_slider_text").text(attr)
    }
})
// click event - Description of gallery archive event ends


// click event  JWG Know Your Venue section image change starts
$('.venue_tab_section .nav-tabs a[data-toggle="tab"], .venue_tab_section .tab-content a[data-toggle="collapse"]').on('click', function () {
    var imgAttr = $(this).attr('data-img');
    $(this).parents(".jwg_know_your_venue_wrapper").find(".venue_img_wrapper img").attr("src", imgAttr)

})
// click event  JWG Know Your Venue section image change ends


//accordian with slider always keep open active slide
$('.accordian_with_slider [data-toggle="collapse"]').on('click', function (e) {
    if ($(this).parents('.accordian_with_slider').find('.collapse.show')) {
        var index = $(this).index('[data-toggle="collapse"]');
        if (index == $('.collapse.show').index('.collapse')) {
            e.stopPropagation();
        }
    }
});


function version() {
    var nAgt = navigator.userAgent;
    var browserName = navigator.appName;
    var fullVersion = '' + parseFloat(navigator.appVersion);
    var majorVersion = parseInt(navigator.appVersion, 10);
    var nameOffset, verOffset, ix;

    // In Opera, the true version is after "Opera" or after "Version"
    if ((verOffset = nAgt.indexOf("Opera")) != -1) {
        browserName = "Opera";
        fullVersion = nAgt.substring(verOffset + 6);
        if ((verOffset = nAgt.indexOf("Version")) != -1)
            fullVersion = nAgt.substring(verOffset + 8);
    }
    // In MSIE, the true version is after "MSIE" in userAgent
    else if ((verOffset = nAgt.indexOf("Trident")) != -1) {
        browserName = "Microsoft Internet Explorer";
        fullVersion = nAgt.substring(verOffset + 8);
        //alert(fullVersion)
    }

    // In Chrome, the true version is after "Chrome" 
    else if ((verOffset = nAgt.indexOf("Chrome")) != -1) {
        browserName = "Chrome/IE edge";
        fullVersion = nAgt.substring(verOffset + 7);
    }
    // In Safari, the true version is after "Safari" or after "Version" 
    else if ((verOffset = nAgt.indexOf("Safari")) != -1) {
        browserName = "Safari";
        fullVersion = nAgt.substring(verOffset + 7);
        if ((verOffset = nAgt.indexOf("Version")) != -1)
            fullVersion = nAgt.substring(verOffset + 8);
    }
    // In Firefox, the true version is after "Firefox" 
    else if ((verOffset = nAgt.indexOf("Firefox")) != -1) {
        browserName = "Firefox";
        fullVersion = nAgt.substring(verOffset + 8);
    }
    // In most other browsers, "name/version" is at the end of userAgent 
    else if ((nameOffset = nAgt.lastIndexOf(' ') + 1) < (verOffset = nAgt.lastIndexOf('/'))) {
        browserName = nAgt.substring(nameOffset, verOffset);
        fullVersion = nAgt.substring(verOffset + 1);
        if (browserName.toLowerCase() == browserName.toUpperCase()) {
            browserName = navigator.appName;
        }
    }
    // trim the fullVersion string at semicolon/space if present
    if ((ix = fullVersion.indexOf(";")) != -1)
        fullVersion = fullVersion.substring(0, ix);
    if ((ix = fullVersion.indexOf(" ")) != -1)
        fullVersion = fullVersion.substring(0, ix);

    majorVersion = parseInt('' + fullVersion, 10);
    if (isNaN(majorVersion)) {
        fullVersion = '' + parseFloat(navigator.appVersion);
        majorVersion = parseInt(navigator.appVersion, 10);
    }

    //alert(browserName + "---" + majorVersion)

    // conditions of browser
    if (((browserName === "Chrome/IE edge") && (majorVersion < 50)) || ((browserName === "Opera") && (majorVersion < 37)) || ((browserName === "Microsoft Internet Explorer") && (majorVersion < 8)) || ((browserName === "Safari") && (majorVersion < 9)) || ((browserName === "Firefox") && (majorVersion < 32))) {
        alert("change your browser")
    }
}

function mobileSubnavigationText() {
    $.fn.isInViewport = function () {
        let elementTop = $(this).offset().top;
        let elementBottom = elementTop + ($(this).outerHeight() / 2);

        let viewportTop = $(window).scrollTop();
        let viewportBottom = viewportTop + ($(window).height() / 2);
        return elementBottom > viewportTop && elementTop < viewportBottom;
    };



    $(window).scroll(function () {
        $("[data-mobile-header]").each(function () {
            if ($(this).isInViewport()) {
                console.log($(this).attr("data-mobile-header"))
                $("#selected").text($(this).attr("data-mobile-header"))
            }
        });

    });
}


function kmavideoplay() {
    $(".kma_text_wrapper .play_href").on("click", function () {
        $(".kma_picture_wrapper, .kma_text_wrapper").hide();
        $(".kma_video_wrapper").show();
        $(".kma_video_wrapper .kma_video_wrapper--video").get(0).play();
    });

    if ($('.kma').hasClass("autoplay")) {
        $(".kma_video_wrapper .kma_video_wrapper--video").get(0).play();
    }
}

function searchBar() {
    $("#searchIcon").on("click", function () {
        $("#search_bar").show();
    });


    $("#search_bar .close").on("click", function () {
        $("#search_bar").hide();
    });

}

function videoPopup() {
    $(".watchVideoClick").on("click", function () {

        var getURL = $(this).attr("data-url");

        $(".video_popup video").attr("src", getURL);

        $(".video_popup video").get(0).play();
    });
    $(".video_popup .close").on("click", function () {

        $(".video_popup video").attr("src", "");

        $(".video_popup video").get(0).pause();
    });
}

function kma_with_thumbnails() {



    var galleryThumbs = new Swiper('.kma_with_thumbnails_thumb_img', {
        spaceBetween: 40,
        slidesPerView: 'auto',
        freeMode: true,
        watchSlidesVisibility: true,
        watchSlidesProgress: true,

    });
    var galleryTop = new Swiper('.kma_with_thumbnails_big_img', {
        spaceBetween: 0,
        speed: 800,
        loop: true,
        thumbs: {
            swiper: galleryThumbs,
        },
        pagination: {
            el: '.swiper-pagination',
        },
        autoplay: {
            delay: 4000,
            disableOnInteraction: false,
        },
    });
}


function scrollingDetect() {


    if ($('.scrolling-detect').length > 0) {
        var scrollingArea = $('.scrolling-detect').offset().top - 65

        $(window).on('scroll', function () {
            var scrollTop = $(this).scrollTop();
            if (scrollTop > scrollingArea) {
                $('.scrolling-detect').addClass('fix_top');
            } else {
                $('.scrolling-detect').removeClass('fix_top');
            }
        });
    }


}



function videoplay() {
    $(".video .play_href").on("click", function () {
        var getImgHeight = $(this).parents(".video").find(".img_box").height()
        $(this).parents(".video").find(".img_box").hide();
        $(this).parents(".video").find(".video_wrapper").show();
        $(this).parents(".video").find(".video_wrapper--video").attr("height", getImgHeight);
        $(this).parents(".video").find(".video_wrapper--video").get(0).play();

    });

    if ($('.video').hasClass("autoplay")) {
        $(this).find(".video_wrapper--video").get(0).play();
    }
}

// window load function starts
$(window).on("load", function () {

    windowNotification();

    kma_with_thumbnails();


    version()
    // common js function
    setTimeout(function () {
        loader();
        AOS.refresh();
        fullWidth();
        //fullWidth2();
    }, 1000);

    customDropdown();
    setHeight("screen_height");
    setHeightInsideNav("screen_height_inside");
    setHeightThreeQuarters("screen_height_Three_Quarters")
    footerCollapseHeader();


    // slider function and realted to slider function
    fractionSlider();
    normalSlider();
    normalSlider3();
    normalSlider2(3, 1.1, 20, 20, "true", "true", "true", "true");
    normalSlider4();
    benefitsSwiper();
    accordianWithSlider("accordian_slider");
    arrowsRight();
    tabSlider();
    showcaseSlider();

    gallyerSlider();

    reviewSlider();

    // other function
    gardenWhatsOnFilter();
    expandcollapse();
    rangeSlider("peopleRangeSlider");
    hallRoomFilter();
    thankyoucomponent();
    sidebarDrop();
    calendar();
    switchView();
    swipertab();
    loadMore();
    searchBar();

    mobileSubnavigationText();

    kmavideoplay();
    videoplay();

    videoPopup();
    scrollingDetect();

})
// window load function ends


//window resize funtion starts
$(window).on('resize', function () {
    windowNotification();
    // common js function
    setTimeout(function () {
        loader();
        AOS.refresh();
        fullWidth();
        //fullWidth2();
    }, 1000);

    //customDropdown();
    setHeight("screen_height");
    setHeightInsideNav("screen_height_inside");
    setHeightThreeQuarters("screen_height_Three_Quarters")
    footerCollapseHeader();

    // slider function and realted to slider function
    normalSlider2(3, 1.1, 20, 20, "true", "true", "true", "true");

    accordianWithSlider("accordian_slider");
    arrowsRight();

    // other function
    gardenWhatsOnFilter();
    expandcollapse();
    thankyoucomponent();
    sidebarDrop();
    tabSlider();
    calendar();

    mobileSubnavigationText()
});
//window resize funtion ends


/* venues js [START]*/
$(".tabs .nav-tabs li a").click(function () {
    $('.tab_mob').text(activeText);
    var activeText2 = $(this).html();
    $('.tab_mob').text(activeText2);
    $(".tab_mob").removeClass("active");
});


$(".tab_mob").click(function () {
    $(this).toggleClass("active");
});

var activeText = $('.tabs .nav-tabs li a.active').text();
/* $('.tab_mob').text(activeText); */

/* venues js [END]*/


/* JWG planning_tools swiper js [START]*/
function tabSlider() {
    var swiperTabslider = new Swiper('.planning-tools-swiper-container', {
        slidesPerView: 3,
        spaceBetween: 30,

        breakpoints: {
            320: {
                slidesPerView: 1,
                spaceBetween: 15,
            },
            767: {
                slidesPerView: 2,
                spaceBetween: 15,
            },
            1024: {
                slidesPerView: 3,
                spaceBetween: 20,
            },
        }
    });
}

$(".planning_tools_lists .nav-tabs li").click(function () {
    tabSlider();
});
/* JWG planning_tools swiper [END]*/

/* JWG showcase swiper [START] */
function showcaseSlider() {
    var sliderThumbs = new Swiper('.slider-thumbs', {
        spaceBetween: 15,
        slidesPerView: 3,
        freeMode: true,
        watchSlidesVisibility: true,
        watchSlidesProgress: true,
    });
    var sliderTop = new Swiper('.slider-top', {
        speed: 800,
        spaceBetween: 0,
        slidesPerView: 1,
        thumbs: {
            swiper: sliderThumbs
        },
        pagination: {
            el: '.swiper-pagination'
        },
        autoplay: {
            delay: 5000
        },
        breakpoints: {

            767: {
                slidesPerView: 1,
                spaceBetween: 0,
            },
        }
    });
}
/* JWG showcase swiper [END] */

function reviewSlider() {

    $('.jwc_review_section').each(function (index, element) {

        $(this).addClass('jwc_review' + index);

        var _reviewSlider = '.jwc_review' + index + ' ' + '.review_slider';


        var breakpoint = window.matchMedia('(min-width:767px)');
        var review;


        var breakpointChecker = function () {

            // if larger viewport and multi-row layout needed
            if (breakpoint.matches === true) {

                // clean up old instances and inline styles when available
                if (review !== undefined) review.destroy(true, true);

                // or/and do nothing
                return;

                // else if a small viewport and single column layout needed
            } else if (breakpoint.matches === false) {

                // fire small viewport version of swiper
                return enableSwiper();

            }

        };

        var enableSwiper = function () {
            review = new Swiper(_reviewSlider, {
                speed: 800,
                slidesPerView: 1.1,
                spaceBetween: 15
            });
        }

        // keep an eye on viewport size changes
        breakpoint.addListener(breakpointChecker);

        // kickstart
        breakpointChecker();


    });

}

/* gallery swiper [START] */
function gallyerSlider() {


    $('.jwc_gallery_section').each(function (index, element) {

        $(this).addClass('jwc_gallery' + index);

        var _galleryThumb = '.jwc_gallery' + index + ' ' + '.gallery_thumbs';
        var _galleryBig = '.jwc_gallery' + index + ' ' + '.gallery_big';
        var _galleryThumbCount = parseInt($('.jwc_gallery' + index).attr('data-thumb-count'));


        var gallerySliderThumbs = new Swiper(_galleryThumb, {
            spaceBetween: 15,
            slidesPerView: 5,
            freeMode: true,
            watchSlidesVisibility: true,
            watchSlidesProgress: true,
        });
        var gallerySliderBig = new Swiper(_galleryBig, {
            speed: 800,
            spaceBetween: 0,
            slidesPerView: 1,
            thumbs: {
                swiper: gallerySliderThumbs
            },
            autoplay: {
                delay: 5000
            },
            breakpoints: {
                320: {
                    slidesPerView: 1.1,
                    spaceBetween: 15,
                },

                767: {
                    slidesPerView: 1,
                    spaceBetween: 0,
                },
            }
        });

    });

}
/* gallery swiper [END] */








/* FAQ and newsroom [START] */
$('.faqs_top_links .navbar-nav .nav-item a').click(function () {
    $('.faqs_top_links .navbar-nav .nav-item a').removeClass('active');
    $(this).addClass('active');


    if ($(window).width() < 991) {
        var sectionTo = $(this).attr('href');
        $('html, body').animate({
            scrollTop: $(sectionTo).offset().top - 350
        }, 10);
    }

});
/* FAQ and newsroom [END] */

/* pressrelease [START] */
$('.press-release #tabs-nav li:first-child').addClass('active');
$('.press-release .tab-content').hide();
$('.press-release .tab-content:first').show();

$('.press-release #tabs-nav li').click(function () {
    $('.press-release #tabs-nav li').removeClass('active');
    $(this).addClass('active');
    $('.press-release .tab-content').hide();

    var activeTab = $(this).find('a').attr('href');
    $(activeTab).fadeIn();
    return false;
});
$('.filter-mobile').click(function () {
    $(this).toggleClass('active');
});
/* pressrelease [END] */

/* press kit [START] */
$('.filter-check .check-box').click(function () {
    $(this).toggleClass('active');
});
/* press kit [START] */


/*map js [START]*/

function initialize() {

    if ($("#map").length > 0) {
        // Basic options for a simple Google Map
        // For more options see: https://developers.google.com/maps/documentation/javascript/reference#MapOptions
        var mapOptions = {
            // How zoomed in you want the map to start at (always required)
            zoom: 11,
            mapTypeControl: false,
            gestureHandling: 'greedy',
            streetViewControl: false,
            scrollwheel: false,

            // The latitude and longitude to center the map (always required)
            center: new google.maps.LatLng(19.064709, 72.8645082),


            // How you would like to style the map. 
            styles: [{
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#f5f5f5"
                    }]
                },
                {
                    "elementType": "labels.icon",
                    "stylers": [{
                        "visibility": "off"
                    }]
                },
                {
                    "elementType": "labels.text.fill",
                    "stylers": [{
                        "color": "#616161"
                    }]
                },
                {
                    "elementType": "labels.text.stroke",
                    "stylers": [{
                        "color": "#f5f5f5"
                    }]
                },
                {
                    "featureType": "administrative",
                    "stylers": [{
                        "visibility": "off"
                    }]
                },
                {
                    "featureType": "poi",
                    "stylers": [{
                        "visibility": "off"
                    }]
                },
                {
                    "featureType": "administrative.land_parcel",
                    "elementType": "labels.text.fill",
                    "stylers": [{
                        "color": "#bdbdbd"
                    }]
                },
                {
                    "featureType": "poi",
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#eeeeee"
                    }]
                },
                {
                    "featureType": "poi",
                    "elementType": "labels.text.fill",
                    "stylers": [{
                        "color": "#757575"
                    }]
                },
                {
                    "featureType": "poi.park",
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#e5e5e5"
                    }]
                },
                {
                    "featureType": "poi.park",
                    "elementType": "labels.text.fill",
                    "stylers": [{
                        "color": "#9e9e9e"
                    }]
                },
                {
                    "featureType": "road",
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#ffffff"
                    }]
                },
                {
                    "featureType": "road.arterial",
                    "elementType": "labels.text.fill",
                    "stylers": [{
                        "color": "#757575"
                    }]
                },
                {
                    "featureType": "road.highway",
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#dadada"
                    }]
                },
                {
                    "featureType": "road.highway",
                    "elementType": "labels.text.fill",
                    "stylers": [{
                        "color": "#616161"
                    }]
                },
                {
                    "featureType": "road.local",
                    "elementType": "labels.text.fill",
                    "stylers": [{
                        "color": "#9e9e9e"
                    }]
                },
                {
                    "featureType": "transit.line",
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#e5e5e5"
                    }]
                },
                {
                    "featureType": "transit.station",
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#eeeeee"
                    }]
                },
                {
                    "featureType": "water",
                    "elementType": "geometry",
                    "stylers": [{
                        "color": "#c9c9c9"
                    }]
                },
                {
                    "featureType": "water",
                    "elementType": "labels.text.fill",
                    "stylers": [{
                        "color": "#9e9e9e"
                    }]
                }
            ]
        };

        var getLocation = document.getElementById('map').getAttribute('data-location')
        //console.log(getLocation)
        const contentString =
            "<div id='content'>" + getLocation + "</div>";
        const infowindow = new google.maps.InfoWindow({
            content: contentString,
        });

        // Get the HTML DOM element that will contain your map 
        // We are using a div with id="map" seen below in the <body>
        var mapElement = document.getElementById('map');

        // Create the Google Map using our element and options defined above
        var map = new google.maps.Map(mapElement, mapOptions);

        // Let's also add a marker while we're at it
        var marker = new google.maps.Marker({
            position: new google.maps.LatLng(19.064709, 72.8645082),
            map: map,
            //title: 'JioWorld Centre (JWC), BKC',
            icon: './assets/images/icons/map-pointer.png'
        });

        infowindow.open(map, marker);
    }

}

google.maps.event.addDomListener(window, 'load', initialize);

/*map js [END]*/


/*convention-centre-venues tab swiper [START]*/
function swipertab() {
    $(".swiper-tab").each(function (index, element) {
        $(this).addClass('jio_' + index);


        var _slide = '.jio_' + index + ' ' + '.swiper-slide';
        var _container = '.jio_' + index + '.swiper-container';

        //console.log(_container)

        var titles = [];
        $(_slide).each(function (i) {
            titles.push($(this).data('title'))
        });

        var swiper = new Swiper(_container, {
            loop: true,
            pagination: {
                el: '.swiper-pagination',
                clickable: true,
                renderBullet: function (index, className) {
                    return '<span class="' + className + '">' + titles[index] + '</span>';
                },
            },

            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
        });

    });


    $('.swiper-tab .swiper-pagination .swiper-pagination-bullet').click(function () {
        $(this).parents('.explorevenues_wrapper_each').find('.expandcard').addClass('show');
        var activeexpand = $(this).parents('.explorevenues_wrapper_each').find('.icon-expand');
        activeexpand.addClass('selected');
        if ($(activeexpand).hasClass("selected")) {
            $(activeexpand).addClass("active");
            $(activeexpand).find('span').text("Collapse");
            $(this).parents('.explorevenues_wrapper_each').addClass('expand');
        }
    });

    $('.icon-expand').click(function () {
        $(this).parents('.explorevenues_wrapper_each').toggleClass('expand');
    });
}
/*convention-centre-venues  tab swiper [END]*/







function windowNotification() {

    var windowWidth = $(window).width();
    var contentHeight = $("#website_notification").outerHeight();


    if ($("#website_notification").hasClass("open")) {
        if (windowWidth <= 992) {
            $("body").addClass("notificationOpen");
            $(".jwc_navbar.jwc_fixed_navbar").css({
                "top": contentHeight
            });
        }
    }




    $(".close_website_notification").click(function () {
        $("#website_notification").remove();
        $("body").removeClass("notificationOpen");
        $(".jwc_navbar.jwc_fixed_navbar").css({
            "top": 0
        });
    });


}


// new code

//sign in code
$('.jwc_signin_wrap_use--btn').on('click', function (e) {
    e.preventDefault();
    $(this).find('span').text(($(this).find('span').text() == 'USE MOBILE' ? 'Use Email' : 'USE MOBILE'));

    $('#jwc_signin_wrap_use--email').toggle();
    $('#jwc_signin_wrap_use--number').toggle();

    $('.jwc_signin_otp .cta-prim').toggleClass('jwc_signin_otp_email');
    $('.jwc_signin_otp .cta-sec').toggleClass('jwc_signin_pwd_email');
})

$('.jwc_field_edit').on('click', function () {
    $(this).next('input').css({
        'pointer-events': 'auto'
    })
})

$(document).on('click', '.jwc_signin_otp .cta-prim', function (e) {
    e.preventDefault();
    $('.jwc_signin_mobile_otp_wrap').addClass('in');
    $('.jwc_signin_email_otp_wrap').removeClass('in');
    $('.jwc_signin_tabs').removeClass('in');
    otptime();
});

$(document).on('click', '.jwc_signin_otp .cta-prim.jwc_signin_otp_email', function (e) {
    e.preventDefault();
    $('.jwc_signin_email_otp_wrap').addClass('in');
    $('.jwc_signin_mobile_otp_wrap').removeClass('in');
    $('.jwc_signin_tabs').removeClass('in');
    otptime();
});


$(document).on('click', '.jwc_signin_otp .cta-sec', function (e) {
    e.preventDefault();
    $('.jwc_signin_mobile_pwd_wrap').addClass('in');
    $('.jwc_signin_email_pwd_wrap').removeClass('in');
    $('.jwc_signin_tabs').removeClass('in');
});

$(document).on('click', '.jwc_signin_otp .cta-sec.jwc_signin_pwd_email', function (e) {
    e.preventDefault();
    $('.jwc_signin_email_pwd_wrap').addClass('in');
    $('.jwc_signin_mobile_pwd_wrap').removeClass('in');
    $('.jwc_signin_tabs').removeClass('in');
});




// register code
$('.jwc_reg_wrap_use--btn').on('click', function (e) {
    e.preventDefault();
    $(this).find('span').text(($(this).find('span').text() == 'USE MOBILE' ? 'Use Email' : 'USE MOBILE'));

    $('#jwc_reg_wrap_use--email').toggle();
    $('#jwc_reg_wrap_use--number').toggle();

    $('.jwc_reg_otp .cta-prim').toggleClass('jwc_reg_otp_email');
})

$(document).on('click', '.jwc_reg_otp .cta-prim', function (e) {
    e.preventDefault();
    $('.jwc_reg_mobile_pwd_wrap').addClass('in');
    $('.jwc_reg_email_pwd_wrap').removeClass('in');
    $('.jwc_signin_wrap_reg_main').hide();
    otptime();
});

$(document).on('click', '.jwc_reg_otp .cta-prim.jwc_reg_otp_email', function (e) {
    e.preventDefault();
    $('.jwc_reg_email_pwd_wrap').addClass('in');
    $('.jwc_reg_mobile_pwd_wrap').removeClass('in');
    $('.jwc_signin_wrap_reg_main').hide();
    otptime();
});


function otptime() {
    var _otptime = 19;
    setInterval(() => {
        if (_otptime > 0) {
            $('.jwc_resend_otp span>span').text(_otptime);
            _otptime--;
        } else {
            $('.jwc_resend_otp > span').hide();
        }
    }, 1000);
}
