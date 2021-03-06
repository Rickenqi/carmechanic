package com.ricky.carmechanic.domain;

import com.ricky.carmechanic.util.type.BaseEntity;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table client_bill
 *
 * @mbggenerated do_not_delete_during_merge
 */
public class ClientBill extends BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill.bill_id
     *
     * @mbggenerated
     */
    private Integer billId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill.register_id
     *
     * @mbggenerated
     */
    private Integer registerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill.payment
     *
     * @mbggenerated
     */
    private Integer payment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill.pay_date
     *
     * @mbggenerated
     */
    private Date payDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill.bill_id
     *
     * @return the value of client_bill.bill_id
     *
     * @mbggenerated
     */
    public Integer getBillId() {
        return billId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill.bill_id
     *
     * @param billId the value for client_bill.bill_id
     *
     * @mbggenerated
     */
    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill.register_id
     *
     * @return the value of client_bill.register_id
     *
     * @mbggenerated
     */
    public Integer getRegisterId() {
        return registerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill.register_id
     *
     * @param registerId the value for client_bill.register_id
     *
     * @mbggenerated
     */
    public void setRegisterId(Integer registerId) {
        this.registerId = registerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill.payment
     *
     * @return the value of client_bill.payment
     *
     * @mbggenerated
     */
    public Integer getPayment() {
        return payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill.payment
     *
     * @param payment the value for client_bill.payment
     *
     * @mbggenerated
     */
    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill.pay_date
     *
     * @return the value of client_bill.pay_date
     *
     * @mbggenerated
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill.pay_date
     *
     * @param payDate the value for client_bill.pay_date
     *
     * @mbggenerated
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }
}