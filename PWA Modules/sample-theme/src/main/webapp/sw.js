var CACHE_NAME = 'samplePWACache';

/**
 * Install PWA.
 */
self.addEventListener('install', function(event) {
  event.waitUntil(
    caches.open(CACHE_NAME).then(function(cache) {
      return cache.addAll([
          '/o/sample-theme/',
          '/o/sample-theme/manifest.json',
          '/o/sample-theme/sw.js'          
      ]);
    })
  )
});

/**
 * Active service worker.
 */
self.addEventListener('active', function activator(event) {
  event.waitUntil(
    caches.keys().then(function(keys) {
      return Promise.all(keys
        .filter(function(key) {
          return key.indexOf(CACHE_NAME) !== 0;
        })
        .map(function(key) {
          return caches.delete(key);
        })
      );
    })
  );
});

/**
 * Intercepet request cache.
 */
self.addEventListener('fetch', function(event) {
  event.respondWith(
    caches.match(event.request).then(function (cachedResponse) {
      return cachedResponse || fetch(event.request);
    })
  );
});
