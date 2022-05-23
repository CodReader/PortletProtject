package com.bogdan.liferay.horsesapp.portlet;

import com.bogdan.lifray.daoapp.api.Horse;
import com.bogdan.lifray.serviceapp.api.Constants;
import com.bogdan.lifray.serviceapp.api.HorseGenerator;
import com.liferay.adaptive.media.exception.AMRuntimeException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import com.bogdan.liferay.horsesapp.constants.HorsesAppPortletKeys;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author bogdan
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=HorsesAppPortlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + HorsesAppPortletKeys.horsesAppPortlet,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class TestActionMethodPortlet extends MVCPortlet {
    private final Logger logger = Logger.getLogger(TestActionMethodPortlet.class.getName());
    private com.bogdan.lifray.serviceapp.api.HorseGenerator horseGenerator;
    private com.bogdan.lifray.daoapp.api.Horse Horse;

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        renderRequest.setAttribute("bet", renderRequest.getParameter("bet"));
        super.render(renderRequest, renderResponse);
    }

    @ProcessAction(name = "actionMethod1")
    public void sampleActionMethod(ActionRequest request, ActionResponse response)
            throws AMRuntimeException.IOException, PortletException, PortalException, SystemException {
        logger.info("This is sampleActionMethod ...");
    }


    public void rend(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        renderRequest.setAttribute("Horse", renderRequest.getAttribute("Horse"));
        super.render(renderRequest, renderResponse);
    }

    @ProcessAction(name = "horseOBJ")
    public static void getObject(ActionRequest request, ActionResponse response) {
        HttpServletRequest request1 = PortalUtil.getHttpServletRequest(request);
        Object object = (Object) request1.getSession().getAttribute("Horse");
        /*Object obj = (Object) request1.setAttribute("Horse", Horse);*/
    }

    @Activate
    public void activate() {
        HorseGenerator.generateHorses(Constants.HORS_SIZE);
    }
}