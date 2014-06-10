package com.picsauditing.data.model.identifier;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BaseContentIdentifier implements IdentifierGenerator {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    private String contentSequence = "SELECT next value FOR BASE_CONTENT_SEQUENCE as nextId";
    private DateTimeFormatter fmt = DateTimeFormat.forPattern("MMddyyyy");

    /**
     * @param sessionImplementor
     * @param o
     * @return
     * @throws org.hibernate.HibernateException
     */
    @Override
    public Serializable generate(SessionImplementor sessionImplementor, Object o) throws HibernateException {
        log.trace("entered BaseContentIdentifier.generate()");

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String nextVal = null;

        try {
            preparedStatement = sessionImplementor.connection().prepareStatement(contentSequence);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                nextVal = resultSet.getString("nextId");
            }
        } catch (SQLException se) {
            log.error("Error creating BaseContentIdentifier {}", se.getMessage());
            throw new HibernateException("Unable to generate an value: " + se.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (Exception ignore) {
            }

            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (Exception ignore) {
            }
        }

        StringBuilder builder = new StringBuilder();
/* Conditionally specify the identifier pattern
        if (o instanceof XXX) {
            builder.append(((XXXX) o).getContentType().getIntValue());
            builder.append(((XXX) o).getObjectType().getIntValue());
        } else if (o instanceof YYYY) { .......}
        } else {
            throw new HibernateException("Invalid Object, can not create Content Id");
        }
*/
        builder.append(fmt.print(new DateTime()));
        builder.append(StringUtils.leftPad(nextVal, 7, "0"));

        Long value = new BigInteger(builder.toString()).longValue();
/*
        if (o instanceof XXXX) {
            XXXX xxxx = (XXXX) o;

            // populate the content id field if not already set
            if (xxx.getContentId() == null || xxx.getId().isEmpty()) {
                xxx.setId(value.toString());
            }

        }
*/
        return value;
    }

}
