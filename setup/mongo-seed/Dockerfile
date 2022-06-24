FROM mongo

COPY ./test-collection /test-collection
RUN dir /test-collection

COPY ./script.sh /
RUN chmod +x /script.sh
ENTRYPOINT ["/script.sh"]