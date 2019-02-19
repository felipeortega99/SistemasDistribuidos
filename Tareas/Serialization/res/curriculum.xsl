<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:output method="html"/>      
    <xsl:template match="/curriculum">
        <html>
            <head>
                <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
                <meta charset="utf-8"/>
                <link rel="stylesheet" type="text/css" herf="//fonts.googleapis.com/css?family=Lato" />                
                <link rel="stylesheet" href="style.css" type="text/css"/>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/css/bootstrap.min.css" integrity="sha384-PDle/QlgIONtM1aqA2Qemk5gPOE7wFq8+Em+G/hmo5Iq0CCmYZLv3fVRDJ4MMwEA" crossorigin="anonymous"></link>
                <!-- <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.0/js/bootstrap.min.js" integrity="sha384-7aThvCh9TypR7fIc2HV4O/nFMVCBwyIUKL8XCtKE+8xgCgl/PQGuFsvShjr74PBp" crossorigin="anonymous"></script> -->
            </head>
            <body class="curriculum__body--grid-container">
                <div class="curriculum__header--flex-container">
                    <div class="curriculum__photo--rounded">
                        <img class="img-rounded"><xsl:attribute name="src">data:image/png;base64,<xsl:value-of select="photo"/></xsl:attribute></img>
                        <h1 class="curriculum__name">
                            <xsl:value-of select="name"/>
                        </h1>
                    </div>                    
                </div>
                
                <div class="curriculum__personal-info--grid-container">                    
                    <div class="personal-info__birthplace">
                        <h3 class="content-title">BIRTHPLACE</h3>
                        <h5>
                            <xsl:value-of select="birthplace"/>
                        </h5>
                        <hr class="hr-personal-info"/>                        
                    </div>                    
                    <div class="personal-info__contact">
                        <h3 class="content-title">CONTACT</h3>
                        <h5>EMAIL</h5>
                        <p>
                            <xsl:value-of select="email"/> | <span class="badge badge-success"><xsl:value-of select="email/@type"/></span>
                        </p>                        
                        <h5>PHONE</h5>
                        <p>
                            +52 <xsl:value-of select="phone"/>
                        </p>
                        <hr class="hr-personal-info"/>
                    </div>                    
                    <div class="personal-info__address">
                        <h3 class="content-title">ADDRESS</h3>                        
                        <p>
                            <xsl:value-of select="address/street"/> # <xsl:value-of select="address/number"/>
                        </p>                        
                        <p>
                            <xsl:value-of select="address/city"/>, <xsl:value-of select="address/state"/>
                        </p>                                                
                        <p>
                            <xsl:value-of select="address/zipcode"/>
                        </p>                                               
                    </div>
                </div>

                <div class="curriculum__jobs--flex-container">
                    <h3 class="content-title jobs__title">JOBS</h3>                      
                    <hr class="hr-jobs"/>                  
                    <xsl:for-each select="jobs/job">
                        <div class="jobs__job--flex-container">
                            <h3>
                                <xsl:value-of select="position"/>
                            </h3>
                            <h5>
                                <xsl:value-of select="company"/>
                            </h5>
                            <div class="job__dates">
                                <date>
                                    <xsl:call-template name="format-date">
                                        <xsl:with-param name="date" select="startdate"/>
                                    </xsl:call-template>                                
                                </date>
                                <span>  -  </span>
                                <date>
                                    <xsl:call-template name="format-date">
                                        <xsl:with-param name="date" select="enddate"/>
                                    </xsl:call-template>                                
                                </date>
                            </div>
                            <hr class="hr-job"/>
                        </div>                        
                    </xsl:for-each>
                </div>
            </body>
        </html>
    </xsl:template>    
    
    <xsl:template name="format-date">
        <xsl:param name="date"/>
        <xsl:variable name="year" select="substring($date, 1, 4)"/>
        <xsl:variable name="month" select="substring($date, 6, 2)"/>
        <xsl:variable name="day" select="substring($date, 9, 2)"/>
        <xsl:variable name="month-name">
            <xsl:call-template name="month-name">
                <xsl:with-param name="month" select="$month"/>
            </xsl:call-template>
        </xsl:variable>
        <xsl:value-of select="concat($month-name, ' ',$day, ', ', $year, ' ')"/>
    </xsl:template>
    
    <xsl:template name="month-name">
        <xsl:param name="month"/>
        <xsl:if test="$month = 1">January</xsl:if>
        <xsl:if test="$month = 2">February</xsl:if>
        <xsl:if test="$month = 3">March</xsl:if>
        <xsl:if test="$month = 4">April</xsl:if>
        <xsl:if test="$month = 5">May</xsl:if>
        <xsl:if test="$month = 6">June</xsl:if>
        <xsl:if test="$month = 7">July</xsl:if>
        <xsl:if test="$month = 8">August</xsl:if>
        <xsl:if test="$month = 9">September</xsl:if>
        <xsl:if test="$month = 10">October</xsl:if>
        <xsl:if test="$month = 11">November</xsl:if>
        <xsl:if test="$month = 12">December</xsl:if>    
    </xsl:template>
</xsl:stylesheet>