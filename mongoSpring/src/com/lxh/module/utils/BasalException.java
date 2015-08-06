package com.lxh.module.utils;

public class BasalException extends RuntimeException
{
  public static final Integer INFO = Integer.valueOf(0);

  public static final Integer DEBUG = Integer.valueOf(1);

  public static final Integer WARN = Integer.valueOf(2);

  public static final Integer ERROR = Integer.valueOf(3);

  public static final Integer NO = Integer.valueOf(5);

  public static final Integer FATAL = Integer.valueOf(6);

  public static final Integer TRACE = Integer.valueOf(7);
  private static final long serialVersionUID = 3340155060024588257L;
  private Integer logLevel;
  private Integer exceptionType;
  private Exception exception;

  public BasalException(Integer logLevel)
  {
    this.logLevel = logLevel;
  }

  public BasalException(Integer logLevel, String message) {
    super(message);
    this.logLevel = logLevel;
  }

  public BasalException(Integer logLevel, Throwable cause) {
    super(cause);
    this.logLevel = logLevel;
  }

  public BasalException(Integer logLevel, String message, Throwable cause) {
    super(message, cause);
    this.logLevel = logLevel;
  }

  public BasalException(Integer logLevel, Integer exceptionType) {
    this.exceptionType = exceptionType;
    this.logLevel = logLevel;
  }

  public BasalException(Integer logLevel, Integer exceptionType, Exception ex) {
    this.exceptionType = exceptionType;
    this.exception = ex;
    this.logLevel = logLevel;
  }

  public BasalException(Integer logLevel, String message, Exception ex) {
    super(message, ex);
    this.logLevel = logLevel;
  }

  public Integer getExceptionType() {
    return this.exceptionType;
  }

  public void setExceptionType(Integer exceptionType) {
    this.exceptionType = exceptionType;
  }

  public Exception getException() {
    return this.exception;
  }

  public void setException(Exception exception) {
    this.exception = exception;
  }

  public Integer getLogLevel() {
    return this.logLevel;
  }

  public void setLogLevel(Integer logLevel) {
    this.logLevel = logLevel;
  }
}