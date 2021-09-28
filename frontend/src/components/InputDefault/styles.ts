import styled, { css } from 'styled-components';

export const InputContainer = styled.div`
  position: relative;
`;

export const InputDefaultContainer = styled.input`
  ${({ theme }) => css`
    position: relative;
    display: flex;
    align-items: center;
    width: 100%;
    height: 100%;
    padding-right: 2.5rem;
    padding-left: 0.5rem;
    padding-top: 0.5rem;
    padding-bottom: 0.5rem;
    border: 3px solid transparent;

    color: ${theme.colors.black_100};
    border-radius: 30px;
    -webkit-border-radius: 30px;
    -moz-border-radius: 30px;
    font-size: 1rem;
    background: ${theme.colors.white_100};
    */ @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const InputDefaultSmall = styled(InputDefaultContainer)`
  ${({ theme }) => css`
    /* background: ${theme.colors.white_100}; */
    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;

export const InputIconDefault = styled.button`
  ${({ theme }) => css`
    position: absolute;
    top: 0;
    bottom: 0;
    right: 13px;
    background-color: transparent;
    color: ${theme.colors.white_100};

    @media only screen and ${theme.medias.mx} {
      grid-template-columns: 1fr;
    }
  `}
`;
