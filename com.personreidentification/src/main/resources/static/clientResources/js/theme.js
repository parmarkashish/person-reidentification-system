(function($) {
    "use strict";


    if ($('.range-slider-price').length) {

        var priceRange = document.getElementById('range-slider-price');

        noUiSlider.create(priceRange, {
            start: [30, 150],
            limit: 200,
            behaviour: 'drag',
            connect: true,
            range: {
                'min': 10,
                'max': 200
            }
        });

        var limitFieldMin = document.getElementById('min-value-rangeslider');
        var limitFieldMax = document.getElementById('max-value-rangeslider');

        priceRange.noUiSlider.on('update', function(values, handle) {
            (handle ? $(limitFieldMax) : $(limitFieldMin)).text(values[handle]);
        });
    };

    if ($('.quantity-spinner').length) {
        $("input.quantity-spinner").TouchSpin({
            
        });
    }

    if ($('.img-popup').length) {
        var groups = {};
        $('.img-popup').each(function() {
            var id = parseInt($(this).attr('data-group'), 10);

            if (!groups[id]) {
                groups[id] = [];
            }

            groups[id].push(this);
        });


        $.each(groups, function() {

            $(this).magnificPopup({
                type: 'image',
                closeOnContentClick: true,
                closeBtnInside: false,
                gallery: { enabled: true }
            });

        });

    };

    if ($('.counter').length) {
        $('.counter').counterUp({
            delay: 10,
            time: 3000
        });
    }
    if ($('.contact-form-validated').length) {
        $('.contact-form-validated').validate({ // initialize the plugin
            rules: {
                name: {
                    required: true
                },
                fname: {
                    required: true
                },
                lname: {
                    required: true
                },
                email: {
                    required: true,
                    email: true
                },
                message: {
                    required: true
                },
                subject: {
                    required: true
                }
            },
            submitHandler: function(form) {
                // sending value with ajax request
                $.post($(form).attr('action'), $(form).serialize(), function(response) {
                    $(form).parent().find('.result').append(response);
                    $(form).find('input[type="text"]').val('');
                    $(form).find('input[type="email"]').val('');
                    $(form).find('textarea').val('');
                });
                return false;
            }
        });
    }
    if ($('.banner-style-one').length) {
        $('.banner-style-one').owlCarousel({
            loop: true,
            items: 1,
            margin: 0,
            dots: true,
            nav: false,
            animateOut: 'slideOutDown',
            animateIn: 'fadeIn',
            active: true,
            smartSpeed: 1000,
            autoplay: 5000
        });
        $('.banner-carousel-btn .left-btn').on('click', function() {
            $('.banner-style-one').trigger('next.owl.carousel');
            return false;
        });
        $('.banner-carousel-btn .right-btn').on('click', function() {
            $('.banner-style-one').trigger('prev.owl.carousel');
            return false;
        });
    }
    // for home 3 testimonials
    if ($('.testimonials-style-three-carousel').length) {
        $('.testimonials-style-three-carousel').owlCarousel({
            loop: true,
            margin: 0,
            nav: false,
            navText: [
                '<i class="cameron-icon-left-arrow"></i>',
                '<i class="cameron-icon-right-arrow"></i>'
            ],
            dots: false,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 1
                },
                600: {
                    items: 1
                },
                991: {
                    items: 1
                },
                1000: {
                    items: 1
                },
                1200: {
                    items: 1
                }
            }
        });
        $('.related-carousel-btn .left-btn').on('click', function() {
            $('.related-product-carousel-one').trigger('next.owl.carousel');
            return false;
        });
        $('.related-carousel-btn .right-btn').on('click', function() {
            $('.related-product-carousel-one').trigger('prev.owl.carousel');
            return false;
        });
    }
    if ($('.related-product-carousel-one').length) {
        $('.related-product-carousel-one').owlCarousel({
            loop: true,
            margin: 30,
            nav: false,
            navText: [
                '<i class="cameron-icon-left-arrow"></i>',
                '<i class="cameron-icon-right-arrow"></i>'
            ],
            dots: false,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 1
                },
                600: {
                    items: 2
                },
                991: {
                    items: 3
                },
                1000: {
                    items: 4
                },
                1200: {
                    items: 4
                }
            }
        });
        $('.related-carousel-btn .left-btn').on('click', function() {
            $('.related-product-carousel-one').trigger('next.owl.carousel');
            return false;
        });
        $('.related-carousel-btn .right-btn').on('click', function() {
            $('.related-product-carousel-one').trigger('prev.owl.carousel');
            return false;
        });
    }
    if ($('.services-carousel-one').length) {
        $('.services-carousel-one').owlCarousel({
            loop: true,
            margin: 30,
            nav: false,
            navText: [
                '<i class="cameron-icon-left-arrow"></i>',
                '<i class="cameron-icon-right-arrow"></i>'
            ],
            stagePadding: 25,
            dots: false,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 1
                },
                600: {
                    items: 2
                },
                991: {
                    items: 2
                },
                1000: {
                    items: 3
                },
                1200: {
                    items: 3
                }
            }
        });
        $('.service-carousel-btn .left-btn').on('click', function() {
            $('.services-carousel-one').trigger('next.owl.carousel');
            return false;
        });
        $('.service-carousel-btn .right-btn').on('click', function() {
            $('.services-carousel-one').trigger('prev.owl.carousel');
            return false;
        });
    }

    if ($('.testi-carousel-one').length) {
        $('.testi-carousel-one').owlCarousel({
            loop: true,
            margin: 0,
            nav: true,
            navText: [
                '<i class="cameron-icon-left-arrow"></i>',
                '<i class="cameron-icon-right-arrow"></i>'
            ],
            dots: true,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 1
                },
                600: {
                    items: 1
                },
                991: {
                    items: 1
                },
                1000: {
                    items: 1
                },
                1200: {
                    items: 1
                }
            }
        });
    }

    if ($('.brands-carousel-one').length) {
        $('.brands-carousel-one').owlCarousel({
            loop: true,
            margin: 0,
            nav: false,
            navText: [
                '<i class="fa fa-long-arrow-left"></i>',
                '<i class="fa fa-long-arrow-right"></i>'
            ],
            dots: false,
            autoWidth: false,
            autoplay: true,
            smartSpeed: 700,
            autoplayTimeout: 5000,
            autoplayHoverPause: true,
            responsive: {
                0: {
                    items: 1
                },
                480: {
                    items: 3
                },
                600: {
                    items: 3
                },
                991: {
                    items: 4
                },
                1000: {
                    items: 5
                },
                1200: {
                    items: 5
                }
            }
        });
    }

    if ($('.scroll-to-target').length) {
        $(".scroll-to-target").on('click', function() {
            var target = $(this).attr('data-target');
            // animate
            $('html, body').animate({
                scrollTop: $(target).offset().top
            }, 1000);

            return false;

        });
    }

    if ($('.main-navigation .navigation-box .sub-menu').length) {
        var subMenu = $('.main-navigation .sub-menu');
        subMenu.parent('li').children('a').append(function() {
            return '<button class="sub-nav-toggler"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>';
        });
        var mainNavToggler = $('.header-navigation .menu-toggler');
        var subNavToggler = $('.main-navigation .sub-nav-toggler');
        mainNavToggler.on('click', function() {
            var Self = $(this);
            var menu = Self.data('target');
            $(menu).slideToggle();
            $(menu).toggleClass('showen');
            return false;
        });
        subNavToggler.on('click', function() {
            var Self = $(this);
            Self.parent().parent().children('.sub-menu').slideToggle();
            return false;
        });
    }

    if ($('.wow').length) {
        var wow = new WOW({
            boxClass: 'wow', // animated element css class (default is wow)
            animateClass: 'animated', // animation css class (default is animated)
            offset: 250, // distance to the element when triggering the animation (default is 0)
            mobile: true, // trigger animations on mobile devices (default is true)
            live: true // act on asynchronously loaded content (default is true)
        });
        wow.init();
    }

    $(window).on('scroll', function() {
        if ($('.scroll-to-top').length) {
            var strickyScrollPos = 100;
            if ($(window).scrollTop() > strickyScrollPos) {
                $('.scroll-to-top').fadeIn(500);
            } else if ($(this).scrollTop() <= strickyScrollPos) {
                $('.scroll-to-top').fadeOut(500);
            }
        };
        if ($('.stricky').length) {
            var headerScrollPos = 100;
            var stricky = $('.stricky');
            if ($(window).scrollTop() > headerScrollPos) {
                stricky.removeClass('slideIn animated');
                stricky.addClass('stricky-fixed slideInDown animated');
            } else if ($(this).scrollTop() <= headerScrollPos) {
                stricky.removeClass('stricky-fixed slideInDown animated');
                stricky.addClass('slideIn animated');
            }
        };
    });

    function galleryMasonaryLayout() {
        if ($('.masonary-layout').length) {
            $('.masonary-layout').isotope({
                layoutMode: 'masonry'
            });
        }

        if ($('.post-filter').length) {
            $('.post-filter li').children('span').on('click', function() {
                var Self = $(this);
                var selector = Self.parent().attr('data-filter');
                $('.post-filter li').children('span').parent().removeClass('active');
                Self.parent().addClass('active');


                $('.filter-layout').isotope({
                    filter: selector,
                    animationOptions: {
                        duration: 500,
                        easing: 'linear',
                        queue: false
                    }
                });
                return false;
            });
        }

        if ($('.selective-post-filter').length) {
            $('.selective-post-filter').on('change', function() {
                var Self = $(this);
                var selector = Self.find(":selected").attr('data-filter');


                $('.filter-layout').isotope({
                    filter: selector,
                    animationOptions: {
                        duration: 500,
                        easing: 'linear',
                        queue: false
                    }
                });
                return false;
            });
        }

        if ($('.post-filter.has-dynamic-filter-counter').length) {
            // var allItem = $('.single-filter-item').length;

            var activeFilterItem = $('.post-filter.has-dynamic-filter-counter').find('li');

            activeFilterItem.each(function() {
                var filterElement = $(this).data('filter');
                console.log(filterElement);
                var count = $('.gallery-content').find(filterElement).length;

                $(this).children('span').append('<span class="count"><b>' + count + '</b></span>');
            });
        };
    }

    $(window).on('load', function() {
        galleryMasonaryLayout();
        if ($('.preloader').length) {
            $('.preloader').fadeOut('slow');
        }
    });

})(jQuery);